package com.teste.back.teste_back_end.modulos.produto.repository;

import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
