package com.teste.back.teste_back_end.modulos.endereco.repository;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByClienteId(Integer clienteId);
}
