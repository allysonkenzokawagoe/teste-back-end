package com.teste.back.teste_back_end.modulos.entrega.service;

import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import com.teste.back.teste_back_end.modulos.entrega.repository.EntregaRepository;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoDto;
import com.teste.back.teste_back_end.modulos.pedido.enums.ESituacaoPedido;
import com.teste.back.teste_back_end.modulos.pedido.service.PedidoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final PedidoService pedidoService;

    @Transactional
    @RabbitListener(queues = "pedido.entrega")
    public void cadastrarEntrega(PedidoDto pedidoDto) {
        var pedido = pedidoService.getById(pedidoDto.id());
        pedido.setSituacaoPedido(ESituacaoPedido.AGUARDANDO_ENTREGA);
        var entrega = Entrega.of(pedidoDto);
        entrega.setPedido(pedido);
        repository.save(entrega);
        pedidoService.save(pedido);
    }

    public List<Entrega> listarEntregas() {
        return repository.findAll();
    }
}
