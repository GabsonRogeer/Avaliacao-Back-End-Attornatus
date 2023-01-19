package com.testeJava.attornatus.service;

import com.testeJava.attornatus.dto.PessoaDTO;
import com.testeJava.attornatus.model.Endereco;
import com.testeJava.attornatus.model.Pessoa;

import java.util.List;

public interface IPessoaService {

    /**
     * Retorna t
     * @return Lista todas as Pessoas que estão salvas no Banco de Dados.
     */
    List<PessoaDTO> findAll();

    /**
     * Retorna uma Pessoa que está no banco de dados de acordo com seu Id.
     * @param id id da Pessoa que será exibido.
     * @return Pessoa de acordo com o Id fornecido.
     */
    PessoaDTO findById(Long id);

    /**
     * Cria uma Pessoa e salva no banco de dados.
     * @param pessoaDTO formulário referente aos dados para criação de uma Pessoa no banco de dados.
     * @return Pessoa recém-criado.
     */
    PessoaDTO create(PessoaDTO pessoaDTO);

    /**
     * Atualiza uma Pessoa e salva no banco de dados.
     * @param id da Pessoa que deverá ser atualizada.
     * @param pessoadto corpo da nova Pessa a ser atualizada.
     * @return Pessoa atualizada com os parametros passado.
     */

    PessoaDTO update(Long id, PessoaDTO pessoadto);

    /**
     * Deleta uma Pessoa específica.
     * @param id id da Pessoa que será removida.
     */
    void deleteById(Long id);
}
