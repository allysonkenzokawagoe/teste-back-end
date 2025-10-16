package com.teste.back.teste_back_end.modulos.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Double preco
) {
}
