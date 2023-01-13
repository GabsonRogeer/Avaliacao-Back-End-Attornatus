package com.testeJava.attornatus.service;

import com.testeJava.attornatus.model.Endereco;

import java.util.List;

public interface IEnderecoService {

    /**
     * Retorna todos os Endereços que estão no banco de dados.
     * @return Lista todos os endereços que estão salvas no Banco de Dados.
     */
    List<Endereco> findAll();

    /**
     * Retorna um Endereço que está no banco de dados de acordo com seu Id.
     * @param id id do Endereço que será exibido.
     * @return Endereço de acordo com o Id fornecido.
     */
    Endereco findById(Long id);

    /**
     * Cria um Endereço e salva no banco de dados.
     * @param endereco formulário referente aos dados para criação de um Endereço no banco de dados.
     * @return Corpo do endereço recém-criado.
     */
    Endereco create(Endereco endereco);

    /**
     * Deleta um Endereço específico.
     * @param id id do Endereço que será removido.
     */
    void deleteById(Long id);
}
