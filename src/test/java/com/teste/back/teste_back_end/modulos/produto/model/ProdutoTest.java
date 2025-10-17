package com.teste.back.teste_back_end.modulos.produto.model;

import org.junit.jupiter.api.Test;

import static com.teste.back.teste_back_end.modulos.produto.helper.ProdutoHelper.umProdutoRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class ProdutoTest {

    @Test
    void of_deveCriarProduto_quandoSolicitado() {
        var produto = Produto.of(umProdutoRequest());

        assertThat(produto.getNome()).isEqualTo("Bola");
        assertThat(produto.getDescricao()).isEqualTo("Bola de Futebol");
        assertThat(produto.getPreco()).isEqualTo(10.0);
    }

}
