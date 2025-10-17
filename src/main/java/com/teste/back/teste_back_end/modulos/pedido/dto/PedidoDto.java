package com.teste.back.teste_back_end.modulos.pedido.dto;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;

public record PedidoDto(
        Integer id,
        Endereco endereco
) {
    public static PedidoDto of(Integer id, Endereco endereco) {
        return new PedidoDto(id, endereco);
    }
}
