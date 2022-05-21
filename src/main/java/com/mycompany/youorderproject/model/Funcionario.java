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
    private LocalDateTime dataContratacao;

    public Funcionario(LocalDateTime dataContratacao, int id, String nome, String userName, 
            String senha, LocalDateTime ultimoAcesso, LocalDateTime dataNasc, String endereco) throws Exception{
        super(id, nome, userName, senha, ultimoAcesso, dataNasc, endereco);
        this.dataContratacao = dataContratacao;
    }

    public LocalDateTime getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDateTime dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
