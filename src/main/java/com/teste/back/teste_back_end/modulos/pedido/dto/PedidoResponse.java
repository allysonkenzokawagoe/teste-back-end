package com.teste.back.teste_back_end.modulos.pedido.dto;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;

import java.util.List;

public record PedidoResponse(
        Integer id,
        Double valorTotal,
        Endereco endereco,
        Integer clienteId,
        List<Integer> produtosPedidosId
) {
    public static PedidoResponse of(Pedido pedido, List<Integer> produtosPedidosId) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getValorTotal(),
                pedido.getEndereco(),
                pedido.getCliente().getId(),
                produtosPedidosId
        );
    }
}
