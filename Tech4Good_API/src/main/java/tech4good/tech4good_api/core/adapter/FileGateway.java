package tech4good.tech4good_api.core.adapter;

import tech4good.tech4good_api.core.domain.file.File;
import tech4good.tech4good_api.core.domain.file.FileModel;
import org.springframework.web.multipart.MultipartFile;

public interface FileGateway {
    File save(MultipartFile file);

    FileModel load(Integer id);

    void delete(Integer id);

    File loadEntity(Integer id);
}
