package com.teste.back.teste_back_end.modulos.pedido.service;

import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import com.teste.back.teste_back_end.modulos.comum.exception.ValidacaoException;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoDto;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoResponse;
import com.teste.back.teste_back_end.modulos.pedido.enums.ESituacaoPedido;
import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import com.teste.back.teste_back_end.modulos.pedido.repository.ProdutoPedidoRepository;
import com.teste.back.teste_back_end.modulos.produto.service.ProdutoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoPedidoService {

    private final ProdutoPedidoRepository repository;
    private final PedidoService pedidoService;
    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final EnderecoService enderecoService;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public void cadastrarProdutoPedido(Integer quantidade, Integer pedidoId, Integer produtoId) {
        var pedido = pedidoService.getById(pedidoId);
        var produto = produtoService.getById(produtoId);
        var subtotal = produto.getPreco() * quantidade;
        var produtoPedido = ProdutoPedido.of(quantidade, subtotal, pedido, produto);

        repository.save(produtoPedido);
    }

    @Transactional
    public PedidoResponse gerarPedido(Integer clienteId, Integer pedidoId, Integer enderecoId) {
        validarPedido(pedidoId);
        var produtosPedidos = buscarPorPedidoId(pedidoId);
        var pedido = pedidoService.getById(pedidoId);
        var cliente = clienteService.getById(clienteId);
        var endereco = enderecoService.getById(enderecoId);
        var produtosPedidosIds = produtosPedidos.stream().map(p ->p.getProduto().getId()).toList();

        produtosPedidos.forEach(
                p -> pedido.setValorTotal(pedido.getValorTotal() + p.getSubtotal())
        );

        pedido.setCliente(cliente);
        pedido.setEndereco(endereco);

        pedidoService.save(pedido);

        var pedidoDto = PedidoDto.of(pedidoId, endereco);
        rabbitTemplate.convertAndSend("pedido.entrega", pedidoDto);

        return PedidoResponse.of(pedido, produtosPedidosIds);
    }

    public List<ProdutoPedido> buscarPorPedidoId(Integer pedidoId) {
        return repository.findAllByPedidoId(pedidoId);
    }

    private void validarPedido(Integer pedidoId) {
        var pedido = pedidoService.getById(pedidoId);
        if(pedido.getSituacaoPedido() != ESituacaoPedido.PEDIDO_ABERTO) {
            throw new ValidacaoException("Pedido já finalizado ou aguardando entrega");
        }
    }
}
