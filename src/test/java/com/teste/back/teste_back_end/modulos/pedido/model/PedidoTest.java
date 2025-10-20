package com.teste.back.teste_back_end.modulos.pedido.model;

import com.teste.back.teste_back_end.modulos.pedido.enums.ESituacaoPedido;
import org.junit.jupiter.api.Test;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umCliente;
import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;
import static org.assertj.core.api.Assertions.assertThat;

public class PedidoTest {

    @Test
    void of_deveCriarUmPedido_quandoSolicitado() {
        var pedido = Pedido.of(umCliente(), umEndereco());

        assertThat(pedido).isNotNull();
        assertThat(pedido.getValorTotal()).isEqualTo(0.0);
        assertThat(pedido.getSituacaoPedido()).isEqualTo(ESituacaoPedido.PEDIDO_ABERTO);
        assertThat(pedido.getEndereco()).isEqualTo(umEndereco());
        assertThat(pedido.getCliente()).isEqualTo(umCliente());
    }
}
