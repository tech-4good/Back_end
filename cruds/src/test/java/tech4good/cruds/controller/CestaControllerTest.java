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
import tech4good.cruds.dto.cesta.CestaRequestDto;
import tech4good.cruds.dto.cesta.CestaResponseDto;
import tech4good.cruds.dto.cesta.CestaUpdateDto;
import tech4good.cruds.entity.Cesta;
import tech4good.cruds.mapper.CestaMapper;
import tech4good.cruds.service.CestaService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    private CestaUpdateDto updateDto;
    private CestaUpdateDto updateDtoInvalido;

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

        //UPDATE DTO
        updateDto = new CestaUpdateDto();
        updateDto.setQuantidadeCestas(10);

        updateDtoInvalido = new CestaUpdateDto();
        updateDtoInvalido.setQuantidadeCestas(-1);
    }

    @Test
    @WithMockUser
    @DisplayName("Deve cadastrar uma cesta com sucesso e deve retornar 201")
    void deveCadastrarUmaCestaComSucesso() throws Exception {
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

    @Test
    @WithMockUser
    @DisplayName("Deve retornar uma lista de cestas cadatradas e deve retornar 200")
    void deveRetornarUmaListaDeCestasCadatradas() throws Exception {
        Cesta cesta = CestaMapper.toEntity(requestDto);
        cestaService.cadastrarCesta(cesta);

        mockMvc.perform(get("/cestas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].tipo").value(responseDto.getTipo()))
                .andExpect(jsonPath("$[0].dataEntradaEstoque").value(responseDto.getDataEntradaEstoque().toString()))
                .andExpect(jsonPath("$[0].quantidadeCestas").value(responseDto.getQuantidadeCestas()));
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 204 quando não houver cestas")
    void deveRetornar204QuandoNaoHouverCestas() throws Exception {
        mockMvc.perform(get("/cestas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar uma cesta cadastrada pelo ID e deve retornar 200")
    void deveRetornarUmaCestaCadastradaPeloId() throws Exception {
        Cesta cesta = CestaMapper.toEntity(requestDto);
        Cesta cestaSalva = cestaService.cadastrarCesta(cesta);
        CestaResponseDto cestaResponseDto = CestaMapper.toResponseDto(cestaSalva);

        mockMvc.perform(get("/cestas/" + cestaResponseDto.getIdCesta()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCesta").value(cestaResponseDto.getIdCesta()))
                .andExpect(jsonPath("$.tipo").value(cestaResponseDto.getTipo()))
                .andExpect(jsonPath("$.dataEntradaEstoque").value(cestaResponseDto.getDataEntradaEstoque().toString()))
                .andExpect(jsonPath("$.quantidadeCestas").value(cestaResponseDto.getQuantidadeCestas()));
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 404 quando não encontrar uma cesta com o ID fornecido")
    void deveRetornar404QuandoNaoEncontrarUmaCestaComOIdFornecido() throws Exception {
        mockMvc.perform(get("/cestas/1000"))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve atualizar uma cesta e deve retornar 200")
    void deveAtualizarUmaCestaERetornar200() throws Exception {
        Cesta cesta = CestaMapper.toEntity(requestDto);
        Cesta cestaSalva = cestaService.cadastrarCesta(cesta);

        mockMvc.perform(patch("/cestas/" + cestaSalva.getIdCesta())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCesta").value(cestaSalva.getIdCesta()))
                .andExpect(jsonPath("$.tipo").value(cestaSalva.getTipo()))
                .andExpect(jsonPath("$.dataEntradaEstoque").value(cestaSalva.getDataEntradaEstoque().toString()))
                .andExpect(jsonPath("$.quantidadeCestas").value(10));
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 404 ao tentar atualizar uma cesta inexistente")
    void deveRetornar404AoTentarAtualizarUmaCestaInexistente() throws Exception {
        mockMvc.perform(patch("/cestas/1000")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 400 ao tentar atualizar uma cesta com quantidade negativa")
    void deveRetornar400AoTentarAtualizarUmaCestaComQuantidadeNegativa() throws Exception {
        Cesta cesta = CestaMapper.toEntity(requestDtoInvalido);
        Cesta cestaSalva = cestaService.cadastrarCesta(cesta);

        mockMvc.perform(patch("/cestas/" + cestaSalva.getIdCesta())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateDtoInvalido)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve remover uma cesta e deve retornar 204")
    void deveRemoverUmaCestaERetornar204() throws Exception {
        Cesta cesta = CestaMapper.toEntity(requestDto);
        Cesta cestaSalva = cestaService.cadastrarCesta(cesta);

        mockMvc.perform(delete("/cestas/" + cestaSalva.getIdCesta()))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 404 ao tentar remover uma cesta inexistente")
    void deveRetornar404AoTentarRemoverUmaCestaInexistente() throws Exception {
        mockMvc.perform(delete("/cestas/1000"))
                .andExpect(status().isNotFound());
    }
}