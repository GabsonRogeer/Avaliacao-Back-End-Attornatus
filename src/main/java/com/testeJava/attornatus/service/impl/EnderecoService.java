package com.testeJava.attornatus.service.impl;

import com.testeJava.attornatus.exceptions.DataBaseException;
import com.testeJava.attornatus.exceptions.EnderecoNotFoundException;
import com.testeJava.attornatus.model.Endereco;
import com.testeJava.attornatus.repository.EnderecoRepository;
import com.testeJava.attornatus.service.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements IEnderecoService {

    @Autowired
    private EnderecoRepository repository;


    @Override
    public List<Endereco> findAll(){
        return repository.findAll();
    }

    @Override
    public Endereco findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException(id));
    }

    @Override
    public Endereco create(Endereco endereco){
        return repository.save(endereco);
    }

    @Override
    public void deleteById(Long id){
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
}
