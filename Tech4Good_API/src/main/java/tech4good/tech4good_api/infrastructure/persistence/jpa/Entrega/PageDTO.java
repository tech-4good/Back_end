package tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * DTO para cachear objetos Page no Redis.
 * PageImpl não pode ser deserializado diretamente pelo Jackson,
 * então usamos este DTO como wrapper.
 */
public class PageDTO<T> {

    private final List<T> content;
    private final int pageNumber;
    private final int pageSize;
    private final long totalElements;

    @JsonCreator
    public PageDTO(
            @JsonProperty("content") List<T> content,
            @JsonProperty("pageNumber") int pageNumber,
            @JsonProperty("pageSize") int pageSize,
            @JsonProperty("totalElements") long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }

    /**
     * Cria um PageDTO a partir de um Page do Spring Data
     */
    public static <T> PageDTO<T> fromPage(Page<T> page) {
        return new PageDTO<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements()
        );
    }

    /**
     * Converte o PageDTO de volta para um Page do Spring Data
     */
    public Page<T> toPage() {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return new PageImpl<>(content, pageable, totalElements);
    }

    public List<T> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }
}

