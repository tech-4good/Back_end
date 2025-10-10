package tech4good.tech4good_api.infrastructure.integration.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "${viacep.url}")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    ViaCepResponseDto buscarCep(@PathVariable String cep);
}
