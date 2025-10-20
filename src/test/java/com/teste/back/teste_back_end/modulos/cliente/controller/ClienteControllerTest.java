package com.teste.back.teste_back_end.modulos.cliente.controller;

import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isBadRequest;
import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isOk;
import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umClienteRequest;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    private static final String ENDPOINT = "/api/cliente";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClienteService service;

    @Test
    void cadastrar_deveRetornarIsOk_quandoRequestValida() {
        isOk(post(ENDPOINT), mockMvc,  umClienteRequest());
        verify(service).cadastrar(umClienteRequest());
    }

    @Test
    void cadastrar_deveRetornarBadRequest_quandoRequestVazia() {
        isBadRequest(post(ENDPOINT), mockMvc);
        verifyNoInteractions(service);
    }

    @Test
    void getById_deveRetornarIsOk_quandoExistir() {
        isOk(get(ENDPOINT + "/1"), mockMvc);
        verify(service).getById(1);
    }
}
