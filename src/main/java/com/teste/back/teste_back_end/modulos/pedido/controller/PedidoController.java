package com.teste.back.teste_back_end.modulos.pedido.controller;

import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoResponse;
import com.teste.back.teste_back_end.modulos.pedido.service.PedidoService;
import com.teste.back.teste_back_end.modulos.pedido.service.ProdutoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/{clienteId}/pedido")
public class PedidoController {

    private final PedidoService service;
    private final ProdutoPedidoService produtoPedidoService;

    @PostMapping
    public void criarPedido(@PathVariable Integer clienteId) {
        service.criarPedido(clienteId);
    }

    @PostMapping("{pedidoId}/{enderecoId}")
    public PedidoResponse gerarPedido(@PathVariable Integer clienteId, @PathVariable Integer pedidoId,
                                      @PathVariable Integer enderecoId) {
        return produtoPedidoService.gerarPedido(clienteId, pedidoId, enderecoId);
    }

}
