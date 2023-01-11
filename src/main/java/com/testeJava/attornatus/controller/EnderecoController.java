package com.testeJava.attornatus.controller;

import com.testeJava.attornatus.dto.EnderecoDTO;
import com.testeJava.attornatus.model.Endereco;
import com.testeJava.attornatus.service.EnderecoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> enderecoList = enderecoService.findAll();
        return ResponseEntity.ok(enderecoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id){
        Endereco endereco = enderecoService.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco){
        endereco = enderecoService.create(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> deleteById(@PathVariable @NotNull Long id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
