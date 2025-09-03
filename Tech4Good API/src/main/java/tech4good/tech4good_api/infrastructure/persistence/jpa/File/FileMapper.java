package tech4good.tech4good_api.infrastructure.persistence.jpa.File;

import tech4good.tech4good_api.core.application.command.file.DeleteFileCommand;
import tech4good.tech4good_api.core.application.command.file.DownloadFileCommand;
import tech4good.tech4good_api.core.application.command.file.UploadFileCommand;
import tech4good.tech4good_api.core.application.dto.file.FileResponseDto;
import tech4good.tech4good_api.core.domain.file.File;
import org.springframework.web.multipart.MultipartFile;

public class FileMapper {

    public static UploadFileCommand toUploadCommand(MultipartFile file) {
        return new UploadFileCommand(file);
    }

    public static DownloadFileCommand toDownloadCommand(Integer id) {
        return new DownloadFileCommand(id);
    }

    public static DeleteFileCommand toDeleteCommand(Integer id) {
        return new DeleteFileCommand(id);
    }

    public static File toDomain(FileEntity entity) {
        return new File(
            entity.getIdFoto(),
            entity.getNomeOriginal(),
            entity.getNomeArmazenamento(),
            entity.getTamanho(),
            entity.getFormato(),
            entity.getDataCriacao()
        );
    }

    public static FileEntity toEntity(File domain) {
        return new FileEntity(
            domain.getId(),
            domain.getNomeOriginal(),
            domain.getNomeArmazenamento(),
            domain.getTamanho(),
            domain.getFormato(),
            domain.getDataCriacao()
        );
    }

    public static FileResponseDto toResponseDto(File domain) {
        return new FileResponseDto(
            domain.getId(),
            domain.getNomeOriginal(),
            domain.getNomeArmazenamento(),
            domain.getTamanho(),
            domain.getFormato(),
            domain.getDataCriacao()
        );
    }
}
