package com.teste.back.teste_back_end.modulos.produto.service;

import com.teste.back.teste_back_end.modulos.produto.dto.ProdutoRequest;
import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import com.teste.back.teste_back_end.modulos.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    @Transactional
    public void cadastrar(ProdutoRequest request) {
        var produto = Produto.of(request);

        repository.save(produto);
    }

    public Produto getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
