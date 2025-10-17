package com.teste.back.teste_back_end.modulos.pedido.helper;

import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import lombok.experimental.UtilityClass;

import static com.teste.back.teste_back_end.modulos.pedido.helper.PedidoHelper.umPedido;
import static com.teste.back.teste_back_end.modulos.produto.helper.ProdutoHelper.umProduto;

@UtilityClass
public class ProdutoPedidoHelper {

    public static ProdutoPedido umProdutoPedido() {
        return new ProdutoPedido(
                1,
                10,
                100.0,
                umProduto(),
                umPedido()
        );
    }

}
