package com.teste.back.teste_back_end.modulos.pedido.repository;

import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Integer> {
    List<ProdutoPedido> findAllByPedidoId(Integer pedidoId);
}
