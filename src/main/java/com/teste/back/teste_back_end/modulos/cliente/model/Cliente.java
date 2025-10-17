package com.teste.back.teste_back_end.modulos.cliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.back.teste_back_end.modulos.cliente.dto.ClienteRequest;
import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
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
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> pedidos;

    public static Cliente of(ClienteRequest request) {
        return Cliente.builder()
                .nome(request.nome())
                .build();
    }

}
