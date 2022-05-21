/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.youorderproject.enums;

/**
 *
 * @author thais
 */
public enum StatusPedido {
    PEDIDO_RECEBIDO {
        @Override
        public String toString() {
            return "Pedido recebido";
        }
    },
    PEDIDO_FILA {
        @Override
        public String toString() {
            return "Pedido em fila de espera";
        }
    },
    PEDIDO_PRONTO {
        @Override
        public String toString(){
            return "Pedido pronto";
        }
    },
    PEDIDO_ENTREGUE {
        @Override
        public String toString(){
            return "Pedido entregue";
        }
    },
    PEDIDO_FINALIZADO {
        @Override
        public String toString(){
            return "Pedido finalizado (pago)";
        }        
    };
}
