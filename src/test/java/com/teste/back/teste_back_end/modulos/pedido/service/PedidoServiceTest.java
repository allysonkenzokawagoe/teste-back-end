package com.teste.back.teste_back_end.modulos.pedido.service;

import com.teste.back.teste_back_end.modulos.cliente.service.ClienteService;
import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import com.teste.back.teste_back_end.modulos.pedido.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umCliente;
import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedido;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @Mock
    private ClienteService clienteService;

    @Mock
    private EnderecoService enderecoService;

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @Test
    void criarPedido_deveCriarPedido_quandoSolicitado() {
        var pedido = Pedido.of(umCliente(), umEndereco());

        when(clienteService.getById(1)).thenReturn(umCliente());
        when(enderecoService.getEnderecoByClienteId(1)).thenReturn(List.of(umEndereco()));

        assertThatCode(() -> service.criarPedido(1)).doesNotThrowAnyException();

        verify(repository).save(pedido);
    }

    @Test
    void getByid_deveRetornarPedido_quandoSolicitado() {
        when(repository.findById(1)).thenReturn(Optional.of(umPedido()));

        assertThatCode(() -> service.getById(1)).doesNotThrowAnyException();
    }

    @Test
    void getByid_deveLancarNotFoundException_quandoNaoEncontrado() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThatCode(() -> service.getById(1))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Pedido não encontrado");
    }

    @Test
    void save_deveSalvarPedido_quandoSolicitado() {
        assertThatCode(() -> service.save(umPedido())).doesNotThrowAnyException();

        verify(repository).save(umPedido());
    }
}
