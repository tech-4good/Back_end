package tech4good.cruds.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tech4good.cruds.dto.cesta.CestaRequestDto;
import tech4good.cruds.dto.cesta.CestaResponseDto;
import tech4good.cruds.entity.Cesta;
import tech4good.cruds.mapper.CestaMapper;
import tech4good.cruds.service.CestaService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CestaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CestaService cestaService;

    @Autowired
    private ObjectMapper objectMapper;

    private CestaRequestDto requestDto;
    private CestaRequestDto requestDtoInvalido;
    private CestaResponseDto responseDto;

    @BeforeEach
    void setUp() {
        //REQUEST DTO
        requestDto = new CestaRequestDto();
        requestDto.setTipo("Kit");
        requestDto.setPesoKg(3.5);
        requestDto.setDataEntradaEstoque(LocalDate.of(2025, 1, 20));
        requestDto.setQuantidadeCestas(37);

        requestDtoInvalido = new CestaRequestDto();
        requestDtoInvalido.setTipo("");
        requestDtoInvalido.setPesoKg(3.5);
        requestDtoInvalido.setDataEntradaEstoque(LocalDate.of(2025, 1, 20));
        requestDtoInvalido.setQuantidadeCestas(37);

        //RESPONSE DTO
        responseDto = new CestaResponseDto(
                1,
                "Kit",
                LocalDate.of(2025, 1, 20),
                37
        );
    }

    @Test
    @WithMockUser
    @DisplayName("Deve cadastrar um produto com sucesso e deve retornar 201")
    void deveCadastrarUmProdutoComSucesso() throws Exception {
        mockMvc.perform(post("/cestas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.tipo").value(requestDto.getTipo()))
                .andExpect(jsonPath("$.dataEntradaEstoque").value(requestDto.getDataEntradaEstoque().toString()))
                .andExpect(jsonPath("$.quantidadeCestas").value(requestDto.getQuantidadeCestas()));
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 400 quando os dados forem inválidos")
    void deveRetornar400QuandoTipoOsDadosForemInvalidos() throws Exception {
        mockMvc.perform(post("/cestas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDtoInvalido)))
                .andExpect(status().isBadRequest());
    }

}