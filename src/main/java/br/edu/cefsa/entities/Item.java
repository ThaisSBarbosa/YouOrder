/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.entities;

import br.edu.cefsa.enums.TipoItem;

/**
 *
 * @author thais
 */
public class Item {

    private TipoItem tipo;
    private double preco;
    private String descricao;
    private Boolean ativoNoCardapio;
    private double tempoEstimadoPreparo; // em minutos
    private int quantidade;

    public Item(TipoItem tipo, double preco, String descricao, Boolean ativoNoCardapio, double tempoEstimadoPreparo, int quantidade) throws  Exception{
        this.tipo = tipo;
        this.preco = verificaPrecoInvalido(preco);
        this.descricao = verificaDescricaoVazia(descricao);
        this.ativoNoCardapio = ativoNoCardapio;
        this.tempoEstimadoPreparo = tempoEstimadoPreparo;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception{
        this.descricao = verificaDescricaoVazia(descricao);
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws Exception{
        this.preco = verificaPrecoInvalido(preco);
    }

    public Boolean getAtivoNoCardapio() {
        return ativoNoCardapio;
    }

    public void setAtivoNoCardapio(Boolean ativoNoCardapio) {
        this.ativoNoCardapio = ativoNoCardapio;
    }

    public double getTempoEstimadoPreparo() {
        return tempoEstimadoPreparo;
    }

    public void setTempoEstimadoPreparo(double tempoEstimadoPreparo) {
        this.tempoEstimadoPreparo = tempoEstimadoPreparo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private double verificaPrecoInvalido(double preco) throws Exception {
        if (preco <= 0) {
            throw new Exception("O preço do item deve ser maior que zero.");
        }
        return preco;
    }
    
    private String verificaDescricaoVazia(String descricao) throws Exception {
        if (descricao == "") {
            throw new Exception("O item deve conter descrição.");
        }
        return descricao;
    }
}
