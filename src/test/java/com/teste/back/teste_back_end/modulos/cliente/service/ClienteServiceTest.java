package com.teste.back.teste_back_end.modulos.cliente.service;

import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import com.teste.back.teste_back_end.modulos.cliente.repository.ClienteRepository;
import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.endereco.repository.EnderecoRepository;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umCliente;
import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umClienteRequest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private EnderecoService enderecoService;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void cadastrar_deveCadastrarCliente_quandoSolicitado() {
        var cliente = Cliente.of(umClienteRequest());

        assertThatCode(() -> clienteService.cadastrar(umClienteRequest())).doesNotThrowAnyException();

        verify(repository).save(cliente);
    }

    @Test
    void getById_deveRetornarCliente_quandoSolicitado() {
        var cliente = umCliente();

        when(repository.findById(1)).thenReturn(Optional.of(cliente));

        assertThatCode(() -> clienteService.getById(1)).doesNotThrowAnyException();
    }

    @Test
    void getbyId_deveLancarNotFounException_quandoNaoEncontrado() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThatCode(() -> clienteService.getById(1))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Cliente não encontrado");
    }
}
