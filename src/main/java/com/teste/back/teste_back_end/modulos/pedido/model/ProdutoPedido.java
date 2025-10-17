package com.teste.back.teste_back_end.modulos.pedido.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PRODUTO_PEDIDO")
public class ProdutoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @Column(name = "SUBTOTAL")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "FK_PRODUTO", foreignKey = @ForeignKey(name = "FK_PRODUTO_PRODTO_PEDIDO"), nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "FK_PEDIDO", foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUTO_PEDIDO"), nullable = false)
    @JsonIgnore
    private Pedido pedido;

    public static ProdutoPedido of(Integer quantidade, Double subtotal, Pedido pedido, Produto produto) {
        return ProdutoPedido.builder()
                .quantidade(quantidade)
                .subtotal(subtotal)
                .pedido(pedido)
                .produto(produto)
                .build();
    }
}
