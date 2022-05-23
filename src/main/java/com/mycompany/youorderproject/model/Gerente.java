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
public class Gerente extends Funcionario {

    public Gerente(LocalDateTime dataContratacao, int id, String nome, String userName,
            String senha, LocalDateTime ultimoAcesso, LocalDateTime dataNasc, String endereco, String pergunta, String resposta) throws Exception{
        super(dataContratacao, id, nome, userName, senha, ultimoAcesso, dataNasc, endereco, pergunta, resposta);
    }
}
