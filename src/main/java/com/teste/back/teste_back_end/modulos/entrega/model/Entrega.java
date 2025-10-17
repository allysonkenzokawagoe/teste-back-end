package com.teste.back.teste_back_end.modulos.entrega.model;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.pedido.dto.PedidoDto;
import com.teste.back.teste_back_end.modulos.pedido.model.Pedido;
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
@Table(name = "ENTREGA")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_ENDERECO", foreignKey = @ForeignKey(name = "FK_ENDERECO_ENTREGA"), nullable = false)
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "FK_PEDIDO", foreignKey = @ForeignKey(name = "FK_PEDIDO_ENTREGA"), nullable = false)
    private Pedido pedido;

    public static Entrega of(PedidoDto pedido) {
       return Entrega.builder()
               .endereco(pedido.endereco())
               .build();
    }
}
