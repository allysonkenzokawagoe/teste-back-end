package com.teste.back.teste_back_end.modulos.entrega.controller;

import com.teste.back.teste_back_end.modulos.entrega.service.EntregaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isOk;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(EntregaController.class)
public class EntregaControllerTest {

    private static final String API_URL = "/api/entrega";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EntregaService service;

    @Test
    void listarEntregas_deveRetornarOk_quandoExistirEntregas() {
        isOk(get(API_URL), mockMvc);
        verify(service).listarEntregas();
    }
}
