package com.testeJava.attornatus.controller;

import com.testeJava.attornatus.dto.EnderecoDTO;
import com.testeJava.attornatus.model.Endereco;
import com.testeJava.attornatus.service.impl.EnderecoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco,
                                           UriComponentsBuilder uriBuilder){
        endereco = enderecoService.create(endereco);
        URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EnderecoDTO> deleteById(@PathVariable @NotNull Long id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
