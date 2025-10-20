package com.teste.back.teste_back_end.modulos.pedido.controller;

import com.teste.back.teste_back_end.modulos.pedido.service.ProdutoPedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isBadRequest;
import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isOk;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProdutoPedidoController.class)
public class ProdutoPedidoControllerTest {

    private static final String API_URL = "/api/produto-pedido";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProdutoPedidoService service;

    @Test
    void cadastrarProdutoPedido_deveRetornarOk_quandoRequestValida() {
        isOk(post(API_URL + "/1/1"), mockMvc, 10);
        verify(service).cadastrarProdutoPedido(10, 1, 1);
    }

    @Test
    void cadastrarProdutoPedido_deveRetornarBadRequest_quandoRequestInvalida() {
        isBadRequest(post(API_URL + "/1/1"), mockMvc);
        verifyNoInteractions(service);
    }

    @Test
    void findByPedidoId_deveRetornarOk_quandoIdValido() {
        isOk(get(API_URL + "/1"), mockMvc);
        verify(service).buscarPorPedidoId(1);
    }
}
