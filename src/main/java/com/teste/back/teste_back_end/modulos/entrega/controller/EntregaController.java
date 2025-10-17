package com.teste.back.teste_back_end.modulos.entrega.controller;

import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import com.teste.back.teste_back_end.modulos.entrega.service.EntregaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/entrega")
public class EntregaController {

    private final EntregaService entregaService;

    @GetMapping
    public List<Entrega> listarEntregas() {
        return entregaService.listarEntregas();
    }

}
