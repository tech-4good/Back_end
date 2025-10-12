package tech4good.tech4good_api.core.application.dto.voluntario;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoluntarioEmailEventDto {
    private Integer voluntarioId;
    private String voluntarioNome;
    private String voluntarioEmail;
    private String tokenRedefinicao;
    private LocalDateTime dataEvento;
}
