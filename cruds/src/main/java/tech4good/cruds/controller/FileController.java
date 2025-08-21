package tech4good.cruds.controller;

import com.amazonaws.services.s3.AmazonS3;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech4good.cruds.entity.FileEntity;
import tech4good.cruds.model.FileModel;
import tech4good.cruds.service.FileService;

import java.net.URI;

@Tag(name = "Controller - Foto do Beneficiado", description = "Operações relacionadas as fotos das pessoas beneficiadas pela ASA.")
@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    private final AmazonS3 s3Client;

    public FileController(FileService fileService, AmazonS3 s3Client) {
        this.fileService = fileService;
        this.s3Client = s3Client;
    }

    @PostMapping
    public ResponseEntity<FileEntity> uploadFile(
            @RequestParam MultipartFile file
    ) {
        FileEntity save = fileService.save(file);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getIdFoto())
                .toUri();

        return ResponseEntity.created(uri).body(save);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(
            @PathVariable Integer id
    ) {

        FileModel file = this.fileService.load(id);

        final String contentTypeValue = "attachment; filename=" + file.getName();

        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentTypeValue)
                .header(HttpHeaders.CONTENT_TYPE, file.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.getSize()))
                .body(file.getContent());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(
            @PathVariable Integer id
    ) {
        this.fileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
