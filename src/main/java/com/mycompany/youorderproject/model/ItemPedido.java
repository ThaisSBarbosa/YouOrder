/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

/**
 *
 * @author carlo
 */
public class ItemPedido {

    private int id;
    private int idPedido;
    private int idItem;
    private int qtdItem;
    private String observacao;

    public ItemPedido() {
    }

    public ItemPedido(int id, int idPedido, int idItem, int qtdItem, String observacao) {
        this.id = id;
        this.idPedido = idPedido;
        this.idItem = idItem;
        this.qtdItem = qtdItem;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
