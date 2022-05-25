/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import java.time.LocalDateTime;

/**
 *
 * @author thais
 */
public class Funcionario extends Usuario {

    private int idFuncionario;
    private LocalDateTime dataContratacao;

    public Funcionario(LocalDateTime dataContratacao, int id, String nome, String userName,
            String senha, LocalDateTime ultimoAcesso, LocalDateTime dataNasc, String endereco,
            String pergunta, String resposta) throws Exception {
        super(id, nome, userName, senha, ultimoAcesso, dataNasc, endereco, pergunta, resposta);
        this.dataContratacao = dataContratacao;
    }

    public Funcionario(int idFuncionario, LocalDateTime dataContratacao, Usuario usuario) throws Exception {
        super(usuario.getId(), usuario.getNome(), usuario.getUserName(), usuario.getSenha(), usuario.getUltimoAcesso(), usuario.getDataNasc(), usuario.getEndereco(), usuario.getPergunta(), usuario.getResposta());
        this.idFuncionario = idFuncionario;
        this.dataContratacao = dataContratacao;
    }

    public LocalDateTime getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDateTime dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
