package com.teste.back.teste_back_end.modulos.cliente.helper;

import com.teste.back.teste_back_end.modulos.cliente.dto.ClienteRequest;
import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import lombok.experimental.UtilityClass;

import static com.teste.back.teste_back_end.modulos.endereco.helper.EnderecoHelper.umEnderecoRequest;

@UtilityClass
public class ClienteHelper {

    public static Cliente umCliente() {
        return new Cliente(
                1,
                "Allyson"
        );
    }

    public static ClienteRequest umClienteRequest() {
        return new ClienteRequest(
                "Allyson",
                umEnderecoRequest()
        );
    }

}
