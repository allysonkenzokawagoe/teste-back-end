package com.teste.back.teste_back_end.modulos.comum.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Component
@RestControllerAdvice
public class AutenticacaoExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse notFoundException(NotFoundException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ValidacaoException.class)
    public ErrorResponse validacaoException(ValidacaoException ex) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }

}
