package com.teste.back.teste_back_end.modulos.entrega.model;

import org.junit.jupiter.api.Test;

import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedidoDto;
import static org.assertj.core.api.Assertions.assertThat;

public class EntregaTest {

    @Test
    void of_deveCriarEntrega_quandoSolicitado() {
        var entrega = Entrega.of(umPedidoDto());

        assertThat(entrega.getEndereco()).isEqualTo(umEndereco());
    }

}
