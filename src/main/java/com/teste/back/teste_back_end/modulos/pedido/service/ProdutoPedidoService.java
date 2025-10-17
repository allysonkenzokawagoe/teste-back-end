package com.teste.back.teste_back_end.modulos.pedido.service;

import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoResponse;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import com.teste.back.teste_back_end.modulos.pedido.repository.ProdutoPedidoRepository;
import com.teste.back.teste_back_end.modulos.produto.service.ProdutoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
        var produtosPedidos = getProdutosPedido(pedidoId);
        var pedido = pedidoService.getById(pedidoId);
        var cliente = clienteService.getById(clienteId);
        var endereco = enderecoService.getById(enderecoId);

        produtosPedidos.forEach(
                p -> pedido.setValorTotal(pedido.getValorTotal() + p.getSubtotal())
        );

        pedido.setProdutos(produtosPedidos);
        pedido.setCliente(cliente);
        pedido.setEndereco(endereco);

        pedidoService.save(pedido);

        return PedidoResponse.of(pedido);
    }

    public List<ProdutoPedido> getProdutosPedido(Integer pedidoId) {
        return repository.findAllByPedidoId(pedidoId);
    }

}
