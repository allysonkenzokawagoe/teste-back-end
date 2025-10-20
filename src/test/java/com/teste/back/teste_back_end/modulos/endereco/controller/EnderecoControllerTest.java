package com.teste.back.teste_back_end.modulos.endereco.controller;

import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isOk;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(EnderecoController.class)
public class EnderecoControllerTest {

    private static final String API_URL = "/api/endereco";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EnderecoService service;

    @Test
    void getById_deveRetornarIsOk_quandoExistir() {
        isOk(get(API_URL), mockMvc);
        verify(service).findAll();
    }
}
