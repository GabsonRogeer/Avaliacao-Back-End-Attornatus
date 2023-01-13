package com.testeJava.attornatus.service.impl;

import com.testeJava.attornatus.dto.PessoaDTO;
import com.testeJava.attornatus.exceptions.DataBaseException;
import com.testeJava.attornatus.model.Pessoa;
import com.testeJava.attornatus.exceptions.PessoaNotFoundException;
import com.testeJava.attornatus.repository.PessoaRepository;
import com.testeJava.attornatus.service.IPessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PessoaDTO> findAll(){
        return repository.findAll().stream()
                .map(p -> modelMapper.map(p, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PessoaDTO findById(Long id){
        Pessoa pessoa = repository.findById(id)
                .orElseThrow( () -> new PessoaNotFoundException(id));
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    @Override
    public PessoaDTO create(PessoaDTO dto){
        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
        pessoa.getEndereco().forEach(enderecos -> enderecos.setPessoa(pessoa));
        Pessoa salvo = repository.save(pessoa);
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    @Override
    public PessoaDTO update(Long id, PessoaDTO dto){
        Pessoa pessoa = repository.getReferenceById(id);
        updateData(pessoa, dto);
        repository.save(pessoa);
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    private void updateData(Pessoa pessoa, PessoaDTO dto) {
        pessoa.setNome(dto.getNome());
        pessoa.setDataNascimento(dto.getDataNascimento());
    }

    @Override
    public void deleteById(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new PessoaNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
}
