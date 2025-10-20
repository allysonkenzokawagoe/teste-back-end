package com.teste.back.teste_back_end.modulos.pedido.service;

import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import com.teste.back.teste_back_end.modulos.comum.exception.ValidacaoException;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoDto;
import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import com.teste.back.teste_back_end.modulos.pedido.repository.ProdutoPedidoRepository;
import com.teste.back.teste_back_end.modulos.produto.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umCliente;
import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedido;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedidoAguardandoEntrega;
import static com.teste.back.teste_back_end.modulos.pedido.helper.ProdutoPedidoHelper.umProdutoPedido;
import static com.teste.back.teste_back_end.modulos.produto.helper.ProdutoHelper.umProduto;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoPedidoServiceTest {

    @Mock
    private ClienteService clienteService;

    @Mock
    private PedidoService pedidoService;

    @Mock
    private ProdutoService produtoService;

    @Mock
    private EnderecoService enderecoService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private ProdutoPedidoRepository repository;

    @InjectMocks
    private ProdutoPedidoService service;

    @Test
    void cadastrarProdutoPedido_deveCadastrar_quandoSolicitado() {
        var pedido = umPedido();
        var produto = umProduto();
        var produtoPedido = ProdutoPedido.of(10, 100.0, pedido, produto);

        when(pedidoService.getById(1)).thenReturn(pedido);
        when(produtoService.getById(1)).thenReturn(produto);

        assertThatCode(() -> service.cadastrarProdutoPedido(10, 1, 1)).doesNotThrowAnyException();

        verify(repository).save(produtoPedido);
    }

    @Test
    void gerarPedido_deveGerarPedidoEEnviarParaFila_quandoSolicitado() {
        var pedidoDto = PedidoDto.of(1, umEndereco());

        when(service.buscarPorPedidoId(1)).thenReturn(List.of(umProdutoPedido()));
        when(pedidoService.getById(1)).thenReturn(umPedido());
        when(clienteService.getById(1)).thenReturn(umCliente());
        when(enderecoService.getById(1)).thenReturn(umEndereco());

        assertThatCode(() -> service.gerarPedido(1, 1, 1)).doesNotThrowAnyException();

        verify(rabbitTemplate).convertAndSend("pedido.entrega", pedidoDto);
    }

    @Test
    void gerarPedido_deveLancarValidacaoException_quandoSituacaoDiferenteAberta() {
        when(pedidoService.getById(1)).thenReturn(umPedidoAguardandoEntrega());

        assertThatCode(() -> service.gerarPedido(1, 1, 1))
                .isInstanceOf(ValidacaoException.class)
                .hasMessage("Pedido já finalizado ou aguardando entrega");
    }


    @Test
    void buscarPorPedidoId_deveBuscarProdutoPedido_quandoSolicitado() {
        when(repository.findAllByPedidoId(1)).thenReturn(List.of(umProdutoPedido()));

        assertThatCode(() -> service.buscarPorPedidoId(1)).doesNotThrowAnyException();
    }
}
