package com.teste.back.teste_back_end.modulos.entrega.helper;

import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import lombok.experimental.UtilityClass;

import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedido;
import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedidoAguardandoEntrega;

@UtilityClass
public class EntregaHelper {

    public static Entrega umaEntrega() {
        return new Entrega(
                null,
                umEndereco(),
                umPedidoAguardandoEntrega()
        );
    }

}
