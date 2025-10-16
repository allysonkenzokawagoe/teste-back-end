package com.teste.back.teste_back_end.modulos.produto.model;

import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO")
    private Double preco;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoPedido> pedidos;

}
