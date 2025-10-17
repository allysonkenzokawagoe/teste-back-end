package com.teste.back.teste_back_end.modulos.endereco.service;

import com.teste.back.teste_back_end.modulos.cliente.model.Cliente;
import com.teste.back.teste_back_end.modulos.comum.exception.NotFoundException;
import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.endereco.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                "Endereço não encontrado"
        ));
    }

    public List<Endereco> getEnderecoByClienteId(Integer clienteId) {
        return repository.findByClienteId(clienteId);
    }

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public void salvar(Endereco endereco, Cliente cliente) {
        endereco.setCliente(cliente);
        repository.save(endereco);
    }

}
