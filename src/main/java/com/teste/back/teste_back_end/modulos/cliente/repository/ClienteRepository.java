package com.teste.back.teste_back_end.modulos.cliente.repository;

import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
