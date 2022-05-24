/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import com.mycompany.youorderproject.utils.Constantes;
import java.time.LocalDateTime;

/**
 *
 * @author thais
 */
public class Usuario {
    private int id;
    private String nome;
    private String userName;
    private String senha;
    private String pergunta;
    private String resposta;
    private LocalDateTime ultimoAcesso;
    private LocalDateTime dataNasc;
    private String endereco;

    public Usuario(int id, String nome, String userName, String senha, LocalDateTime ultimoAcesso, 
                   LocalDateTime dataNasc, String endereco, String pergunta, String resposta) throws Exception{
        this.id = verificaIdDiferenteDeZero(id);
        this.nome = verificaNomeDiferenteDeVazio(nome);
        this.userName = verificaUserNameLimiteCaracteres(userName);
        this.senha = senha;
        this.ultimoAcesso = ultimoAcesso;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }
    
    public Usuario(String nome, String userName, String senha, 
            LocalDateTime dataNasc, String endereco, String pergunta, String resposta) throws Exception{
        this.nome = verificaNomeDiferenteDeVazio(nome);
        this.userName = verificaUserNameLimiteCaracteres(userName);
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        this.nome = verificaNomeDiferenteDeVazio(nome);
    }

    public LocalDateTime getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDateTime dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception{
        this.id = verificaIdDiferenteDeZero(id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws Exception{
        this.userName = verificaUserNameLimiteCaracteres(userName);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }    
    
    private int verificaIdDiferenteDeZero(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Não é possível cadastrar cliente com id ou menor que zero.");
        }
        return id;
    }
        
    private String verificaNomeDiferenteDeVazio(String nome) throws Exception {
        if (nome == null || "".equals(nome)) {
            throw new Exception("Não é possível cadastrar cliente sem nome.");
        }
        return nome;
    }
    
    private String verificaUserNameLimiteCaracteres(String username) throws Exception {
        if (username.length() > Constantes.LIMITE_CARACTERES_USERNAME) {
            throw new Exception("O username deve ter até " + Constantes.LIMITE_CARACTERES_USERNAME + " caracteres.");
        }
        return username;
    }
}
