package com.teste.back.teste_back_end.modulos.cliente.model;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "FK_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO"))
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
