package com.teste.back.teste_back_end.modulos.produto.service;

import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import com.teste.back.teste_back_end.modulos.produto.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.teste.back.teste_back_end.modulos.produto.helper.ProdutoHelper.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    void cadastrar_deveCadastrarProduto_quandoSolicitado() {
        var produto = Produto.of(umProdutoRequest());

        assertThatCode(() -> service.cadastrar(umProdutoRequest())).doesNotThrowAnyException();

        verify(repository).save(produto);
    }

    @Test
    void cadastrar_naoDeveCadastrarProduto_quandoRequestVazia() {
        var produto = Produto.of(umProdutoRequestVazia());


        verify(repository, never()).save(produto);
    }

    @Test
    void getById_deveRetornarProduto_quandoSolicitado() {
        when(repository.findById(1)).thenReturn(Optional.of(umProduto()));

        assertThatCode(() -> service.getById(1)).doesNotThrowAnyException();
    }

    @Test
    void getById_deveLancarNotFoundException_quandoNaoEncontrado() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThatCode(() -> service.getById(1))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Produto não encontrado");
    }

}
