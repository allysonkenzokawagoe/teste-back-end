package com.teste.back.teste_back_end.modulos.cliente.model;

import com.teste.back.teste_back_end.modulos.cliente.dto.ClienteRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public static Cliente of(ClienteRequest request) {
        return Cliente.builder()
                .nome(request.nome())
                .build();
    }

}
