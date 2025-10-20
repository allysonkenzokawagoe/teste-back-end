package com.teste.back.teste_back_end.modulos.produto.controller;

import com.teste.back.teste_back_end.modulos.produto.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isBadRequest;
import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isOk;
import static com.teste.back.teste_back_end.modulos.produto.helper.ProdutoHelper.umProdutoRequest;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {

    private static final String API_URL = "/api/produto";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProdutoService service;

    @Test
    void cadastrar_deveRetornarOk_quandoRequestValida() {
        isOk(post(API_URL), mockMvc, umProdutoRequest());
        verify(service).cadastrar(umProdutoRequest());
    }

    @Test
    void cadastrar_deveRetornarBadRequest_quandoRequestInvalida() {
        isBadRequest(post(API_URL), mockMvc);
        verifyNoInteractions(service);
    }

    @Test
    void buscarPorId_deveRetornarOk_quandoExistir() {
        isOk(get(API_URL + "/1"), mockMvc);
        verify(service).getById(1);
    }
}
