package com.testeJava.attornatus.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String logradouro;
    private Long cep;
    private Integer numero;
    private String cidade;
    private Boolean principal;
    @ManyToOne(optional = false)
    private Pessoa pessoa;

}
