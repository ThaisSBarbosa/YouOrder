/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.entities;

import br.edu.cefsa.enums.RestricaoAlimentar;
import java.time.LocalDateTime;

/**
 *
 * @author thais
 */
public class Cliente extends Usuario {
    private RestricaoAlimentar restricaoAlimentar;
    private int qtdPedidosFidelidade;

    public Cliente(RestricaoAlimentar restricaoAlimentar, int qtdPedidosFidelidade, int id, String nome, 
                    String userName, String senha, LocalDateTime ultimoAcesso, 
                    LocalDateTime dataNasc, String endereco) throws Exception{
        super(id, nome, userName, senha, ultimoAcesso, dataNasc, endereco);
        this.restricaoAlimentar = restricaoAlimentar;
        this.qtdPedidosFidelidade = qtdPedidosFidelidade;
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
