package com.teste.back.teste_back_end.modulos.pedido.model;

import com.teste.back.teste_back_end.modulos.produto.model.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "FK_PRODUTO", foreignKey = @ForeignKey(name = "FK_PRODUTO_PRODTO_PEDIDO"), nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "FK_PEDIDO", foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUTO_PEDIDO"), nullable = false)
    private Pedido pedido;
}
