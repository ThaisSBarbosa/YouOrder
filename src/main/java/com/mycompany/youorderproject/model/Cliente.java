/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import java.time.LocalDateTime;

/**
 *
 * @author thais
 */
public class Cliente extends Usuario {

    private int idCliente;

    private RestricaoAlimentar restricaoAlimentar;
    private int qtdPedidosFidelidade;

    public Cliente(RestricaoAlimentar restricaoAlimentar, int qtdPedidosFidelidade, int id, String nome,
            String userName, String senha, LocalDateTime ultimoAcesso,
            LocalDateTime dataNasc, String endereco, String pergunta, String resposta) throws Exception {
        super(id, nome, userName, senha, ultimoAcesso, dataNasc, endereco, pergunta, resposta);
        this.restricaoAlimentar = restricaoAlimentar;
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
    }

    public Cliente(int idCliente, Usuario usuario, RestricaoAlimentar restricaoAlimentar, int qtdPedidosFidelidade) throws Exception {

        super(usuario.getId(), usuario.getNome(), usuario.getUserName(), usuario.getSenha(),
                usuario.getUltimoAcesso(), usuario.getDataNasc(), usuario.getEndereco(),
                usuario.getPergunta(), usuario.getResposta());
        this.idCliente = idCliente;
        this.restricaoAlimentar = restricaoAlimentar;
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public RestricaoAlimentar getRestricaoAlimentar() {
        return restricaoAlimentar;
    }

    public void setRestricaoAlimentar(RestricaoAlimentar restricaoAlimentar) {
        this.restricaoAlimentar = restricaoAlimentar;
    }

    public int getQtdPedidosFidelidade() {
        return qtdPedidosFidelidade;
    }

    public void setQtdPedidosFidelidade(int qtdPedidosFidelidade) {
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
    }
}
