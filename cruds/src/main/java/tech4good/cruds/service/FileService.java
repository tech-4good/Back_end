package tech4good.cruds.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import tech4good.cruds.entity.FileEntity;
import tech4good.cruds.model.FileModel;
import tech4good.cruds.repository.FileEntityRepository;

import java.io.IOException;

@Slf4j
@Service
public class FileService{

    private final StorageService storageService;
    private final FileEntityRepository fileEntityRepository;

    public FileService(StorageService storageService, FileEntityRepository fileEntityRepository) {
        this.storageService = storageService;
        this.fileEntityRepository = fileEntityRepository;
    }

    @Transactional
    public FileEntity save(MultipartFile file) {
        try {
            FileEntity fileEntity = createFileEntity(file);
            FileEntity savedEntity = this.fileEntityRepository.save(fileEntity);

            storageService.save(savedEntity.getNomeArmazenamento(), file.getBytes());

            return savedEntity;
        } catch (IOException e) {
            log.error("[FILE-ERROR] Failed to save file", e);
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Failed to save file due to IO issues", e);
        }
    }

    public FileModel load(int fileId) {
        FileEntity fileEntity = this.fileEntityRepository.findById(fileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found"));

        byte[] bytes = storageService.load(fileEntity.getNomeArmazenamento());
        ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);

        FileModel model = createFileModel(fileEntity, bytes);

        return model;
    }

    public void delete(int fileId) {
        FileEntity fileEntity = this.fileEntityRepository.findById(fileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found"));

        storageService.delete(fileEntity.getNomeArmazenamento());
        this.fileEntityRepository.delete(fileEntity);
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

        FileModel model = new FileModel();
        model.setName(fileEntity.getNomeOriginal());
        model.setContentType(fileEntity.getFormato());
        model.setSize(fileEntity.getTamanho());
        model.setContent(byteArrayResource);

        return model;
    }
}
