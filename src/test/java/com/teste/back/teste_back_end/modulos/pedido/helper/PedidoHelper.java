package com.teste.back.teste_back_end.modulos.pedido.helper;

import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoDto;
import com.teste.back.teste_back_end.modulos.pedido.enums.ESituacaoPedido;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import lombok.experimental.UtilityClass;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umCliente;
import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEndereco;

@UtilityClass
public class PedidoHelper {

    public static Pedido umPedido() {
        return new Pedido(
                1,
                100.0,
                ESituacaoPedido.PEDIDO_ABERTO,
                umCliente(),
                umEndereco()
        );
    }

    public static Pedido umPedidoAguardandoEntrega() {
        return new Pedido(
                1,
                100.0,
                ESituacaoPedido.AGUARDANDO_ENTREGA,
                umCliente(),
                umEndereco()
        );
    }

    public static PedidoDto umPedidoDto() {
        return new PedidoDto(
                1,
                umEndereco()
        );
    }

}
