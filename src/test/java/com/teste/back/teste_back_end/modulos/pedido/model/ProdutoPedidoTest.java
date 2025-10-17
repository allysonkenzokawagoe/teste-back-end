package com.teste.back.teste_back_end.modulos.pedido.model;

import org.junit.jupiter.api.Test;

import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedido;
import static com.teste.back.teste_back_end.modulos.produto.helper.ProdutoHelper.umProduto;
import static org.assertj.core.api.Assertions.assertThat;

public class ProdutoPedidoTest {

    @Test
    void of_deveCriarProdutoPedido_quandoSolicitado() {
        var produtoPedido = ProdutoPedido.of(10, 100.0, umPedido(), umProduto());

        assertThat(produtoPedido).isNotNull();
        assertThat(produtoPedido.getQuantidade()).isEqualTo(10);
        assertThat(produtoPedido.getSubtotal()).isEqualTo(100.0);
        assertThat(produtoPedido.getPedido()).isEqualTo(umPedido());
        assertThat(produtoPedido.getProduto()).isEqualTo(umProduto());
    }
}
