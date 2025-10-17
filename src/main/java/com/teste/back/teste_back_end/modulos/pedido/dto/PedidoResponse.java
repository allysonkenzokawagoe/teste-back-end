package com.teste.back.teste_back_end.modulos.pedido.dto;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;

import java.util.List;
import java.util.stream.Collectors;

public record PedidoResponse(
        Integer id,
        Double valorTotal,
        Endereco endereco,
        Integer clienteId,
        List<Integer> produtosPedidosId
) {
    public static PedidoResponse of(Pedido pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getValorTotal(),
                pedido.getEndereco(),
                pedido.getCliente().getId(),
                pedido.getProdutos().stream().map(ProdutoPedido::getId).collect(Collectors.toList())
        );
    }
}
