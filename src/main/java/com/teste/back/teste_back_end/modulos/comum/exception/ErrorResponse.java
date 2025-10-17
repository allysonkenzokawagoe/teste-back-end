package com.teste.back.teste_back_end.modulos.comum.exception;

public record ErrorResponse(
        int status,
        String mensage
) {
}
