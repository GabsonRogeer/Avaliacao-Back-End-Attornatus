package com.testeJava.attornatus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private LocalDate dataNascimento;
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="pessoa")
    @JsonIgnore
    private List<Endereco> enderecos = new ArrayList<>();

}
