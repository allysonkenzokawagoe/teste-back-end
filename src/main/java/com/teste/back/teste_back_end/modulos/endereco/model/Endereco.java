package com.teste.back.teste_back_end.modulos.endereco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.back.teste_back_end.modulos.endereco.dto.EnderecoRequest;
import com.teste.back.teste_back_end.modulos.entrega.model.Entrega;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @OneToMany(mappedBy = "endereco")
    @JsonIgnore
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "endereco")
    @JsonIgnore
    private List<Entrega> entregas;

    public static Endereco of(EnderecoRequest request) {
        return Endereco.builder()
                .logradouro(request.logradouro())
                .numero(request.numero())
                .complemento(request.complemento())
                .cidade(request.cidade())
                .build();
    }
}
