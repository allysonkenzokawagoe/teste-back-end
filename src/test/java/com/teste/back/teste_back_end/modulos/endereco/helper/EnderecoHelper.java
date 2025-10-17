package com.teste.back.teste_back_end.modulos.endereco.helper;

import com.teste.back.teste_back_end.modulos.endereco.dto.EnderecoRequest;
import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import lombok.experimental.UtilityClass;

import static com.teste.back.teste_back_end.modulos.cliente.helper.ClienteHelper.umCliente;

@UtilityClass
public class EnderecoHelper {

    public static Endereco umEndereco() {
        return new Endereco(
                1,
                "Avenida Bandeirantes",
                1151,
                "Ao lado do Viscardi",
                "Londrina",
                umCliente()
        );
    }

    public static EnderecoRequest umEnderecoRequest() {
        return new EnderecoRequest(
              "Avenida Bandeirantes",
                1151,
                "Ao lado do Viscardi",
                "Londrina"
        );
    }

}
