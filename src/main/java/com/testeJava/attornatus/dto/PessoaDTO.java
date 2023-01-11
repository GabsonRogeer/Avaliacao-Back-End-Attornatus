package com.testeJava.attornatus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private List<EnderecoDTO> enderecos = new ArrayList<>();
}
