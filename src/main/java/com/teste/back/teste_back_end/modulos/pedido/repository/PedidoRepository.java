package com.teste.back.teste_back_end.modulos.pedido.repository;

import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
