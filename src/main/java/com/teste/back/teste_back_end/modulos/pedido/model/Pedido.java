package com.teste.back.teste_back_end.modulos.pedido.model;

import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.pedido.enums.ESituacaoPedido;
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
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "SITUACAO")
    @Enumerated(EnumType.STRING)
    private ESituacaoPedido situacaoPedido;

    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE_PEDIDO"), nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_ENDERECO",foreignKey = @ForeignKey(name = "FK_ENDERECO_PEDIDO"), nullable = false)
    private Endereco endereco;

    public static Pedido of(Cliente cliente, Endereco endereco) {
        return Pedido.builder()
                .valorTotal(0.0)
                .situacaoPedido(ESituacaoPedido.PEDIDO_ABERTO)
                .cliente(cliente)
                .endereco(endereco)
                .build();
    }
}
