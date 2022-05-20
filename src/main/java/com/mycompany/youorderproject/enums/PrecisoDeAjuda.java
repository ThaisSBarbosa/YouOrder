/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.enums;

/**
 *
 * @author jessica
 */
public enum PrecisoDeAjuda {
    PEDIDO_ATRASADO {
        @Override
        public String toString() {
            return "O meu pedido está atrasado";
        }
    },
    OBSERVACAO_PEDIDO {
        @Override
        public String toString() {
            return "Quero adicionar uma observação ao meu pedido";
        }
    },
    FALAR_ATENDENTE {
        @Override
        public String toString(){
            return "Quero falar com um atendente";
        }
    };
}
