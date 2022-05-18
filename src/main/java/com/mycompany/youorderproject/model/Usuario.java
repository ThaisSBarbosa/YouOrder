/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import java.time.LocalDateTime;

/**
 *
 * @author carlo
 */
public class Usuario {
    private int id;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;
    private char sexo;
    private char tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id, String email, String senha, LocalDateTime dataCriacao, char sexo, char tipoUsuario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.sexo = sexo;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
