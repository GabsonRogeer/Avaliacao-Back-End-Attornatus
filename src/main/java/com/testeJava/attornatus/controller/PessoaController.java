package com.testeJava.attornatus.controller;


import com.testeJava.attornatus.dto.PessoaDTO;
import com.testeJava.attornatus.service.PessoaService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PessoaDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable @NotNull Long id){
        PessoaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO dto){
        PessoaDTO pessoaDTO = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable @NotNull Long id, @RequestBody PessoaDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> deleteById(@PathVariable @NotNull Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
