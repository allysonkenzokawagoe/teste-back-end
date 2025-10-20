package com.teste.back.teste_back_end.modulos.pedido.controller;

import com.teste.back.teste_back_end.modulos.pedido.service.PedidoService;
import com.teste.back.teste_back_end.modulos.pedido.service.ProdutoPedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.teste.back.teste_back_end.conifg.helper.TestRequisitionHelper.isOk;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(PedidoController.class)
public class PedidoControllerTest {

    private static final String API_URL = "/api/1/pedido";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PedidoService service;

    @MockitoBean
    private ProdutoPedidoService produtoPedidoService;

    @Test
    void criarPedido_deveRetornarOk_quandoIdExistir() {
        isOk(post(API_URL), mockMvc);
        verify(service).criarPedido(1);
    }

    @Test
    void gerarPedido_deveRetornarOk_quandoIdsExistentes() {
        isOk(post(API_URL + "/1/1"), mockMvc);
        verify(produtoPedidoService).gerarPedido(1, 1, 1);
    }

}
