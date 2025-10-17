package com.teste.back.teste_back_end.modulos.endereco.service;

import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.endereco.repository.EnderecoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository repository;

    @InjectMocks
    private EnderecoService service;

    @Test
    void getById_deveRetornarEndereco_quandoSolicitado() {
        when(repository.findById(1)).thenReturn(Optional.of(umEndereco()));

        assertThatCode(() -> service.getById(1)).doesNotThrowAnyException();
    }

    @Test
    void getById_deveLancarNotFoundException_quandoNaoEncontrado() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThatCode(() -> service.getById(1))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Endereço não encontrado");
    }

    @Test
    void getEnderecoByClienteId_deveRetornarEndereco_quandoSolicitado() {
        when(repository.findByClienteId(1)).thenReturn(List.of(umEndereco()));

        assertThatCode(() -> service.getEnderecoByClienteId(1)).doesNotThrowAnyException();
    }

    @Test
    void findAll_deveRetornarTodosEnderecos_quandoSolicitado() {
        when(repository.findAll()).thenReturn(List.of(umEndereco()));

        assertThatCode(() -> service.findAll()).doesNotThrowAnyException();
    }

    @Test
    void salvar_deveSalvarUmEndereco_quandoSolicitado() {
        when(repository.save(umEndereco())).thenReturn(umEndereco());

        assertThatCode(() -> service.salvar(umEndereco())).doesNotThrowAnyException();
    }

}
