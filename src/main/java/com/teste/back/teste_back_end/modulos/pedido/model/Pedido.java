package com.teste.back.teste_back_end.modulos.pedido.model;

import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE", foreignKey = @ForeignKey(name = "FK_CLIENTE"), nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_ENDERECO",foreignKey = @ForeignKey(name = "FK_ENDERECO"), nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "pedido")
    private List<ProdutoPedido> produtos;
}
