package com.teste.back.teste_back_end.modulos.endereco.service;

import com.teste.back.teste_back_end.modulos.endereco.model.Endereco;
import com.teste.back.teste_back_end.modulos.endereco.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

}
