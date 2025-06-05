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
import tech4good.cruds.dto.endereco.EnderecoRequestDto;
import tech4good.cruds.dto.endereco.EnderecoResponseDto;
import tech4good.cruds.dto.endereco.EnderecoUpdateDto;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.mapper.EnderecoMapper;
import tech4good.cruds.service.EnderecoService;

import java.time.LocalDate;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EnderecoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ObjectMapper objectMapper;

    // REQUEST DTO
    private EnderecoRequestDto requestDto;
    private EnderecoRequestDto requestDtoInvalido;

    // RESPONSE DTO
    private EnderecoResponseDto responseDto;

    //UPDATE DTO
    private EnderecoUpdateDto updateDto;

    private LocalDate dataSaida;

    @BeforeEach
    void setUp() {

        requestDto = new EnderecoRequestDto();
        requestDto.setLogradouro("Avenida Marechal Tito");
        requestDto.setNumero(234);
        requestDto.setComplemento("A");
        requestDto.setBairro("São Miguel Paulista");
        requestDto.setCidade("São Paulo");
        requestDto.setEstado("SP");
        requestDto.setCep("01001000");
        requestDto.setTipoCesta("Kit");
        requestDto.setDataEntrada(LocalDate.of(2025, 1, 10));
        requestDto.setMoradia("Alugada");
        requestDto.setTipoMoradia("Apartamento");
        requestDto.setStatus("Aberto");

        requestDtoInvalido = new EnderecoRequestDto();
        requestDtoInvalido.setLogradouro("");
        requestDtoInvalido.setNumero(234);
        requestDtoInvalido.setComplemento("A");
        requestDtoInvalido.setBairro("São Miguel Paulista");
        requestDtoInvalido.setCidade("São Paulo");
        requestDtoInvalido.setEstado("SP");
        requestDtoInvalido.setCep("010010000");
        requestDtoInvalido.setTipoCesta("Kit");
        requestDtoInvalido.setDataEntrada(LocalDate.of(2025, 1, 10));
        requestDtoInvalido.setMoradia("Alugada");
        requestDtoInvalido.setTipoMoradia("Apartamento");
        requestDtoInvalido.setStatus("Aberto");

        responseDto = new EnderecoResponseDto(
                1,
                "Avenida Marechal Tito",
                234,
                "A",
                "São Miguel Paulista",
                "São Paulo",
                "SP",
                "01001000",
                "Kit",
                LocalDate.of(2025, 1, 10),
                LocalDate.of(2025, 6, 22),
                "Alugada",
                "Apartamento",
                "Aberto"
        );

        updateDto = new EnderecoUpdateDto();
        updateDto.setStatus("Fechado");
    }

    @Test
    @WithMockUser
    @DisplayName("Deve cadastrar um endereço e deve retornar 201")
    void deveCadastrarUmEnderecoComSucesso() throws Exception {
        mockMvc.perform(post("/enderecos")
                .contentType(MediaType.APPLICATION_JSON).
                content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.logradouro").value(requestDto.getLogradouro()))
                .andExpect(jsonPath("$.numero").value(requestDto.getNumero()))
                .andExpect(jsonPath("$.complemento").value(requestDto.getComplemento()))
                .andExpect(jsonPath("$.bairro").value(requestDto.getBairro()))
                .andExpect(jsonPath("$.cidade").value(requestDto.getCidade()))
                .andExpect(jsonPath("$.estado").value(requestDto.getEstado()))
                .andExpect(jsonPath("$.cep").value(requestDto.getCep()))
                .andExpect(jsonPath("$.tipoCesta").value(requestDto.getTipoCesta()))
                .andExpect(jsonPath("$.dataEntrada").value(requestDto.getDataEntrada().toString()))
                .andExpect(jsonPath("$.moradia").value(requestDto.getMoradia()))
                .andExpect(jsonPath("$.tipoMoradia").value(requestDto.getTipoMoradia()))
                .andExpect(jsonPath("$.status").value(requestDto.getStatus()));
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 400 quando os dados forem invalidos")
    void deveRetornar400QuandoDadosForemInvalidos() throws Exception {
        mockMvc.perform(post("/enderecos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDtoInvalido)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar uma lista de enderecos cadastradas e deve retornar 200")
    void deveRetornarUmaListaDeEnderecosCadastrados() throws Exception{
        Endereco endereco = EnderecoMapper.toEntity(requestDto);
        enderecoService.cadastrarEndereco(endereco);

        mockMvc.perform(get("/enderecos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].logradouro").value(responseDto.getLogradouro()))
                .andExpect(jsonPath("$[0].numero").value(responseDto.getNumero()))
                .andExpect(jsonPath("$[0].complemento").value(responseDto.getComplemento()))
                .andExpect(jsonPath("$[0].bairro").value(responseDto.getBairro()))
                .andExpect(jsonPath("$[0].cidade").value(responseDto.getCidade()))
                .andExpect(jsonPath("$[0].estado").value(responseDto.getEstado()))
                .andExpect(jsonPath("$[0].cep").value(responseDto.getCep()))
                .andExpect(jsonPath("$[0].tipoCesta").value(responseDto.getTipoCesta()))
                .andExpect(jsonPath("$[0].dataEntrada").value(responseDto.getDataEntrada().toString()))
                //.andExpect(jsonPath("$[0].dataSaida").value(responseDto.getDataSaida().toString()))
                .andExpect(jsonPath("$[0].moradia").value(responseDto.getMoradia()))
                .andExpect(jsonPath("$[0].tipoMoradia").value(responseDto.getTipoMoradia()))
                .andExpect(jsonPath("$[0].status").value(responseDto.getStatus()))
                .andExpect(jsonPath("$.dataSaida").doesNotExist());

    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 204 quando não houver enderecos")
    void deveRetornar204QuandoNaoHouverEnderecos() throws Exception {
        mockMvc.perform(get("/enderecos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar um endereco cadastrado pelo ID e deve retornar 200")
    void deveRetornarUmEnderecoCadastradoPeloId() throws Exception {
        Endereco endereco = EnderecoMapper.toEntity(requestDto);
        Endereco enderecoSalvo = enderecoService.cadastrarEndereco(endereco);
        EnderecoResponseDto enderecoResponseDto = EnderecoMapper.toResponseDto(enderecoSalvo);

        mockMvc.perform(get("/enderecos/" + enderecoResponseDto.getIdEndereco()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEndereco").value(enderecoResponseDto.getIdEndereco()))
                .andExpect(jsonPath("$.logradouro").value(enderecoResponseDto.getLogradouro()))
                .andExpect(jsonPath("$.numero").value(enderecoResponseDto.getNumero()))
                .andExpect(jsonPath("$.complemento").value(enderecoResponseDto.getComplemento()))
                .andExpect(jsonPath("$.bairro").value(enderecoResponseDto.getBairro()))
                .andExpect(jsonPath("$.cidade").value(enderecoResponseDto.getCidade()))
                .andExpect(jsonPath("$.estado").value(enderecoResponseDto.getEstado()))
                .andExpect(jsonPath("$.cep").value(enderecoResponseDto.getCep()))
                .andExpect(jsonPath("$.tipoCesta").value(enderecoResponseDto.getTipoCesta()))
                .andExpect(jsonPath("$.dataEntrada").value(enderecoResponseDto.getDataEntrada().toString()))
                .andExpect(jsonPath("$.moradia").value(enderecoResponseDto.getMoradia()))
                .andExpect(jsonPath("$.tipoMoradia").value(enderecoResponseDto.getTipoMoradia()))
                .andExpect(jsonPath("$.status").value(enderecoResponseDto.getStatus()))
                .andExpect(jsonPath("$.dataSaida").doesNotExist());
    }

    @Test
    @WithMockUser
    @DisplayName("Deve retornar 404 quando não encontrar um endereco com o ID fornecido")
    void deveRetornar404QuandoNaoEncontrarUmEnderecoComIdFornecido() throws Exception{
        mockMvc.perform(get("/enderecos/1000"))
                .andExpect(status().isNotFound());
    }
}