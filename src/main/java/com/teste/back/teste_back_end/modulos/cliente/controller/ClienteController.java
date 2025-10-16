package com.teste.back.teste_back_end.modulos.cliente.controller;

import com.teste.back.teste_back_end.modulos.cliente.dto.ClienteRequest;
import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid ClienteRequest request) {
        service.cadastrar(request);
    }

    @GetMapping("{id}")
    public Cliente buscarPorId(@PathVariable Integer id) {
        return service.getById(id);
    }

}
