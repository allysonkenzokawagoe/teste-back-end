package com.teste.back.teste_back_end.modulos.endereco.model;

import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CIDADE")
    private String cidade;

    @OneToMany(mappedBy = "enderecoEntrega")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "endereco")
    private List<Entrega> entregas;
}
