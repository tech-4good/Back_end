package tech4good.cruds.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech4good.cruds.dto.endereco.EnderecoApiCepDto;

@FeignClient(name = "logradouroIntegration", url = "${viacep.url}")
public interface LogradouroIntegration {

    @GetMapping("/{cep}/json/")
    EnderecoApiCepDto buscarLogradouro(@PathVariable String cep);

}
