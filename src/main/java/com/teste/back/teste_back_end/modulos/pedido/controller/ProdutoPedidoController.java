package com.teste.back.teste_back_end.modulos.pedido.controller;

import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import com.teste.back.teste_back_end.modulos.pedido.service.ProdutoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/produto-pedido")
public class ProdutoPedidoController {

    private final ProdutoPedidoService service;

    @PostMapping("{pedidoId}/{produtoId}")
    public void cadastrarProdutoPedido(@RequestBody Integer quantidade, @PathVariable Integer pedidoId, @PathVariable Integer produtoId) {
        service.cadastrarProdutoPedido(quantidade, pedidoId, produtoId);
    }

    @GetMapping("{pedidoId}")
    public List<ProdutoPedido> findByPedidoId(@PathVariable Integer pedidoId) {
        return service.buscarPorPedidoId(pedidoId);
    }
}
