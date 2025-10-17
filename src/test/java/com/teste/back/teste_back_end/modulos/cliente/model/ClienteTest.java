package com.teste.back.teste_back_end.modulos.cliente.model;

import org.junit.jupiter.api.Test;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umClienteRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class ClienteTest {

    @Test
    void of_deveCriarCliente_quandoSolicitado() {
        var cliente = Cliente.of(umClienteRequest());

        assertThat(cliente.getNome()).isEqualTo("Allyson");
    }
}
