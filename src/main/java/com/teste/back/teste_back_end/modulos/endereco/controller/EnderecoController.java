package com.teste.back.teste_back_end.modulos.endereco.controller;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    private final EnderecoService service;

    @GetMapping
    public List<Endereco> getEnderecos() {
        return service.findAll();
    }

}
