package com.teste.back.teste_back_end.modulos.produto.controller;

import com.teste.back.teste_back_end.modulos.produto.dto.ProdutoRequest;
import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import com.teste.back.teste_back_end.modulos.produto.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid ProdutoRequest request){
        service.cadastrar(request);
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable Integer id){
        return service.getById(id);
    }
}
