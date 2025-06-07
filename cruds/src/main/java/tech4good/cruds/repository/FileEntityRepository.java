package tech4good.cruds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech4good.cruds.entity.FileEntity;

public interface FileEntityRepository extends JpaRepository<FileEntity, Integer> {
}
