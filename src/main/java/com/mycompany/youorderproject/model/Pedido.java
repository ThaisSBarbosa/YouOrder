/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import com.mycompany.youorderproject.utils.Constantes;
import com.mycompany.youorderproject.enums.StatusPedido;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author thais
 */
public class Pedido {

    private int id;
    private Cliente cliente;
    //private ArrayList<Item> itens = new ArrayList<Item>();
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private int numeroMesa;
    private StatusPedido status;
    private double valor;

    public Pedido(int id, Cliente cliente, LocalDateTime dataInicio, LocalDateTime dataFinal, int numeroMesa, StatusPedido status, double valor) throws Exception {
        this.id = id;
        this.cliente = verificaPedidoPossuiCliente(cliente);
        //this.itens = verificaPedidoPossuiItens(itens);
        this.dataInicio = verificaDataInicioMaiorQueDataAtual(dataInicio);
        this.dataFinal = dataFinal;
        this.numeroMesa = verificaMesaDiferenteDeZero(numeroMesa);
        this.status = status;
        this.valor = verificaDescontoFidelidadeNoPedido(valor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public ArrayList<Item> getItens() {
//        return itens;
//    }
//
//    public void setItens(ArrayList<Item> itens) throws Exception {
//        this.itens = verificaPedidoPossuiItens(itens);
//    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) throws Exception {
        this.cliente = verificaPedidoPossuiCliente(cliente);
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) throws Exception {
        this.dataInicio = verificaDataInicioMaiorQueDataAtual(dataInicio);
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) throws Exception {
        this.numeroMesa = verificaMesaDiferenteDeZero(numeroMesa);
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = verificaDescontoFidelidadeNoPedido(valor);
    }

    public double getTempoTotalMinutos() {
        return ChronoUnit.MINUTES.between(this.getDataInicio(), this.getDataFinal());
    }

    private ArrayList<Item> verificaPedidoPossuiItens(ArrayList<Item> itens) throws Exception {
        if (itens == null || itens.size() <= 0) {
            throw new Exception("O pedido deve conter ao menos um item.");
        }
        return itens;
    }

    private int verificaMesaDiferenteDeZero(int numeroMesa) throws Exception {
        if (numeroMesa == 0) {
            throw new Exception("O pedido deve conter número da mesa.");
        }
        return numeroMesa;
    }

    private Cliente verificaPedidoPossuiCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("O pedido deve conter um cliente cadastrado.");
        }
        return cliente;
    }

    private LocalDateTime verificaDataInicioMaiorQueDataAtual(LocalDateTime dataInicio) throws Exception {
        if (ChronoUnit.MINUTES.between(dataInicio, LocalDateTime.now()) <= 0) {
            throw new Exception("A data de início do pedido não deve ser maior que a data atual.");
        }
        return dataInicio;
    }

    private double verificaDescontoFidelidadeNoPedido(double valor) {
        if (this.getCliente().getQtdPedidosFidelidade() == Constantes.QTD_PEDIDOS_DESCONTO_FIDELIDADE) {
            if (valor <= Constantes.VALOR_DESCONTO_FIDELIDADE) {
                valor = 0;
            } else {
                valor -= Constantes.VALOR_DESCONTO_FIDELIDADE;
            }
            this.getCliente().setQtdPedidosFidelidade(0);
        }
        return valor;
    }
}
