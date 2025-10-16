package com.teste.back.teste_back_end.modulos.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequest(
        @NotBlank
        String logradouro,
        @NotNull
        Integer numero,
        @NotBlank
        String complemento,
        @NotBlank
        String cidade
) {
}
