package tech4good.tech4good_api.infrastructure.integration.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech4good.tech4good_api.config.web.FeignConfig;

@FeignClient(name = "viaCepClient", url = "${viacep.url}", configuration = FeignConfig.class)
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    ViaCepResponseDto buscarCep(@PathVariable String cep);
}
