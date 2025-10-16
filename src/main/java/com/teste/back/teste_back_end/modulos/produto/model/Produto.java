package com.teste.back.teste_back_end.modulos.produto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.back.teste_back_end.modulos.pedido.model.ProdutoPedido;
import com.teste.back.teste_back_end.modulos.produto.dto.ProdutoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
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
    @JsonIgnore
    private List<ProdutoPedido> pedidos;

    public static Produto of(ProdutoRequest request) {
        return Produto.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .preco(request.preco())
                .build();
    }
}
