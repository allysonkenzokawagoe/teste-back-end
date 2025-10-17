package com.teste.back.teste_back_end.modulos.produto.helper;

import com.teste.back.teste_back_end.modulos.produto.dto.ProdutoRequest;
import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoHelper {

    public static Produto umProduto() {
        return new Produto(
                1,
                "Bola",
                "Bola de Futebol",
                10.0
        );
    }

    public static ProdutoRequest umProdutoRequest() {
        return new ProdutoRequest(
                "Bola",
                "Bola de Futebol",
                10.0
        );
    }

    public static ProdutoRequest umProdutoRequestVazia() {
        return new ProdutoRequest(
                null,
                null,
                null
        );
    }
}
