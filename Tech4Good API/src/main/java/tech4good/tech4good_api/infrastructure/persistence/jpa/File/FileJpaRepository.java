package tech4good.tech4good_api.infrastructure.persistence.jpa.File;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileJpaRepository extends JpaRepository<FileEntity, Integer> {
}
