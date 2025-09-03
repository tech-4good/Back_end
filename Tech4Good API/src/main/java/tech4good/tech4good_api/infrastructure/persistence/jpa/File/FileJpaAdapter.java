package tech4good.tech4good_api.infrastructure.persistence.jpa.File;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.adapter.StorageService;
import tech4good.tech4good_api.core.domain.file.File;
import tech4good.tech4good_api.core.domain.file.FileModel;

import java.io.IOException;

@Slf4j
@Service
public class FileJpaAdapter implements FileGateway {

    private final StorageService storageService;
    private final FileJpaRepository fileJpaRepository;

    public FileJpaAdapter(StorageService storageService, FileJpaRepository fileJpaRepository) {
        this.storageService = storageService;
        this.fileJpaRepository = fileJpaRepository;
    }

    @Override
    @Transactional
    public File save(MultipartFile file) {
        try {
            FileEntity fileEntity = createFileEntity(file);
            FileEntity savedEntity = this.fileJpaRepository.save(fileEntity);

            storageService.save(savedEntity.getNomeArmazenamento(), file.getBytes());

            return FileMapper.toDomain(savedEntity);
        } catch (IOException e) {
            log.error("[FILE-ERROR] Failed to save file", e);
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Failed to save file due to IO issues", e);
        }
    }

    @Override
    public FileModel load(Integer fileId) {
        FileEntity fileEntity = this.fileJpaRepository.findById(fileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found"));

        byte[] bytes = storageService.load(fileEntity.getNomeArmazenamento());

        return createFileModel(fileEntity, bytes);
    }

    @Override
    public void delete(Integer fileId) {
        FileEntity fileEntity = this.fileJpaRepository.findById(fileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found"));

        storageService.delete(fileEntity.getNomeArmazenamento());
        this.fileJpaRepository.delete(fileEntity);
    }

    @Override
    public File loadEntity(Integer fileId) {
        FileEntity fileEntity = this.fileJpaRepository.findById(fileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found"));

        return FileMapper.toDomain(fileEntity);
    }

    private FileEntity createFileEntity(MultipartFile file) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setNomeOriginal(file.getOriginalFilename());
        fileEntity.setTamanho(file.getSize());
        fileEntity.setFormato(file.getContentType());
        fileEntity.setNomeArmazenamento(generateStoredName(file));

        return fileEntity;
    }

    private String generateStoredName(MultipartFile file) {
        return System.currentTimeMillis() + "_" + file.getOriginalFilename();
    }

    private FileModel createFileModel(FileEntity fileEntity, byte[] bytes) {
        ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);

        return new FileModel(
            fileEntity.getNomeOriginal(),
            fileEntity.getFormato(),
            fileEntity.getTamanho(),
            byteArrayResource
        );
    }
}
