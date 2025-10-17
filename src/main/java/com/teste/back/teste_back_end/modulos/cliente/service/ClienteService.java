package com.teste.back.teste_back_end.modulos.cliente.service;

import com.teste.back.teste_back_end.modulos.cliente.dto.ClienteRequest;
import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import com.teste.back.teste_back_end.modulos.cliente.repository.ClienteRepository;
import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.endereco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final EnderecoService enderecoService;

    @Transactional
    public void cadastrar(ClienteRequest request) {
        var cliente = Cliente.of(request);
        var endereco = Endereco.of(request.endereco());
        cliente.setEnderecos(List.of(endereco));

        repository.save(cliente);
        enderecoService.salvar(endereco, cliente);
    }

    public Cliente getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                "Cliente não encontrado"
        ));
    }

}
