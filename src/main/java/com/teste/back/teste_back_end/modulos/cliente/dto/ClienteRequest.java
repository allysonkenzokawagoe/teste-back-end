package com.teste.back.teste_back_end.modulos.cliente.dto;

import com.teste.back.teste_back_end.modulos.endereco.dto.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
        @NotBlank
        String nome,
        @NotNull
        EnderecoRequest endereco
) {
}
