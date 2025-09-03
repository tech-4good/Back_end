package tech4good.tech4good_api.core.application.command.file;

import org.springframework.web.multipart.MultipartFile;

public record UploadFileCommand(
    MultipartFile file
) {
}
