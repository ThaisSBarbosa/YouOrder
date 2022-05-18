/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente extends Usuario{
    
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private int perfilRestricao;
    private int qtdPedidosFidelidade;

    public Cliente(int id, String nome, LocalDate dataNascimento, String endereco, int perfilRestricao, int qtdPedidosFidelidade) {
        this.setId(id);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.perfilRestricao = perfilRestricao;
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
    }

    public Cliente(String nome, LocalDate dataNascimento, String endereco, int perfilRestricao, int qtdPedidosFidelidade, int id, String email, String senha, LocalDateTime dataCriacao, char sexo, char tipoUsuario) {
        super(id, email, senha, dataCriacao, sexo, tipoUsuario);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.perfilRestricao = perfilRestricao;
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getPerfilRestricao() {
        return perfilRestricao;
    }

    public void setPerfilRestricao(int perfilRestricao) {
        this.perfilRestricao = perfilRestricao;
    }

    public int getQtdPedidosFidelidade() {
        return qtdPedidosFidelidade;
    }

    public void setQtdPedidosFidelidade(int qtdPedidosFidelidade) {
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
    }
}
