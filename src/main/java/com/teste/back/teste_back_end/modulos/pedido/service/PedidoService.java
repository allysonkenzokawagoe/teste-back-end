package com.teste.back.teste_back_end.modulos.pedido.service;

import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import com.teste.back.teste_back_end.modulos.pedido.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteService clienteService;
    private final EnderecoService enderecoService;

    @Transactional
    public void criarPedido(Integer clienteId) {
        var cliente = clienteService.getById(clienteId);
        var enderecos = enderecoService.getEnderecoByClienteId(clienteId);
        var pedido = Pedido.of(cliente, enderecos.getFirst());
        repository.save(pedido);
    }

    public Pedido getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                "Produto não encontrado"
        ));
    }

    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

}
