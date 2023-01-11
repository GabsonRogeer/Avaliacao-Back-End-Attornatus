package com.testeJava.attornatus.dto;

import com.testeJava.attornatus.model.Pessoa;
import com.testeJava.attornatus.model.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private Long cep;
    private Integer numero;
    private String cidade;
    private Tipo tipo;
}
