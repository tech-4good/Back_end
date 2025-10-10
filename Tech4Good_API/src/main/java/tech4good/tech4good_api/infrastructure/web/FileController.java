package tech4good.tech4good_api.infrastructure.web;

import com.amazonaws.services.s3.AmazonS3;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech4good.tech4good_api.core.application.usecase.file.*;
import tech4good.tech4good_api.core.domain.file.File;
import tech4good.tech4good_api.core.domain.file.FileModel;
import tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileMapper;

import java.net.URI;

@Tag(name = "Controller - Foto do Beneficiado", description = "Operações relacionadas às fotos das pessoas beneficiadas pela ASA.")
@RestController
@RequestMapping("/files")
public class FileController {

    private final UploadFileUseCase uploadFileUseCase;
    private final DownloadFileUseCase downloadFileUseCase;
    private final DeleteFileUseCase deleteFileUseCase;
    private final AmazonS3 s3Client;

    public FileController(UploadFileUseCase uploadFileUseCase,
                         DownloadFileUseCase downloadFileUseCase,
                         DeleteFileUseCase deleteFileUseCase,
                         AmazonS3 s3Client) {
        this.uploadFileUseCase = uploadFileUseCase;
        this.downloadFileUseCase = downloadFileUseCase;
        this.deleteFileUseCase = deleteFileUseCase;
        this.s3Client = s3Client;
    }

    @PostMapping
    public ResponseEntity<File> uploadFile(@RequestParam MultipartFile file) {
        var command = FileMapper.toUploadCommand(file);
        File savedFile = uploadFileUseCase.executar(command);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedFile.getId())
                .toUri();

        return ResponseEntity.created(uri).body(savedFile);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id) {
        var command = FileMapper.toDownloadCommand(id);
        FileModel file = downloadFileUseCase.executar(command);

        final String contentTypeValue = "attachment; filename=" + file.getName();

        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentTypeValue)
                .header(HttpHeaders.CONTENT_TYPE, file.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.getSize()))
                .body(file.getContent());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Integer id) {
        var command = FileMapper.toDeleteCommand(id);
        deleteFileUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
