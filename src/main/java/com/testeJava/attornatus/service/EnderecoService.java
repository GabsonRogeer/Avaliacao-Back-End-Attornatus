package com.testeJava.attornatus.service;

import com.testeJava.attornatus.dto.EnderecoDTO;
import com.testeJava.attornatus.exceptions.DataBaseException;
import com.testeJava.attornatus.exceptions.EnderecoNotFoundException;
import com.testeJava.attornatus.model.Endereco;
import com.testeJava.attornatus.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;


    public List<Endereco> findAll(){
        return repository.findAll();
    }

    public Endereco findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException(id));
    }

    public Endereco create(Endereco endereco){
        return repository.save(endereco);
    }

    public void deleteById(Long id){
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
}
