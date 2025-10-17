package com.teste.back.teste_back_end.modulos.endereco.model;

import org.junit.jupiter.api.Test;

import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEnderecoRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class EnderecoTest {

    @Test
    void of_deveCriarEndereco_quandoSolicitado() {
        var endereco = Endereco.of(umEnderecoRequest());

        assertThat(endereco.getLogradouro()).isEqualTo("Avenida Bandeirantes");
        assertThat(endereco.getNumero()).isEqualTo(1151);
        assertThat(endereco.getComplemento()).isEqualTo("Ao lado do Viscardi");
        assertThat(endereco.getCidade()).isEqualTo("Londrina");
    }

}
