package tech4good.tech4good_api.core.application.dto.common;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

public class PagedResponseMapper {

    public static <T, R> PagedResponseDto<R> toPagedResponseDto(Page<T> page, Function<T, R> mapper) {
        List<R> content = page.getContent().stream()
                .map(mapper)
                .toList();

        return new PagedResponseDto<>(
                content,
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize(),
                page.hasNext(),
                page.hasPrevious()
        );
    }
}
