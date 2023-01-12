package com.testeJava.attornatus.dto;

import lombok.*;

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
    private Boolean principal;
}
