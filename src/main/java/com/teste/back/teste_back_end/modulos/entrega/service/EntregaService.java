package com.teste.back.teste_back_end.modulos.entrega.service;

import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import com.teste.back.teste_back_end.modulos.entrega.repository.EntregaRepository;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoDto;
import com.teste.back.teste_back_end.modulos.pedido.service.PedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final PedidoService pedidoService;

    @Transactional
    @RabbitListener(queues = "pedido.entrega")
    public void cadastrarEntrega(PedidoDto pedidoDto) {
        var entrega = Entrega.of(pedidoDto);
        entrega.setPedido(pedidoService.getById(pedidoDto.id()));
        repository.save(entrega);
    }

    public List<Entrega> listarEntregas() {
        return repository.findAll();
    }
}
