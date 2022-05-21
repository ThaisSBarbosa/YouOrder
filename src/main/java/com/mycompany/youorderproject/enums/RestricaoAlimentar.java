/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.enums;

/**
 *
 * @author carlo
 */
public enum RestricaoAlimentar {
    SEM_RESTRICAO {
        @Override
        public String toString() {
            return "Sem Restrição";
        }
    },
    VEGETARIANO {
        @Override
        public String toString() {
            return "Vegetariano";
        }
    },
    VEGANO {
        @Override
        public String toString() {
            return "Vegano";
        }
    },
    INTOL_LACTOSE {
        @Override
        public String toString() {
            return "Intolerante a Lactose";
        }
    },
    INTOL_GLUTEN {
        @Override
        public String toString() {
            return "Intolerante a Gluten";
        }
    },
    LOW_CARB {
        @Override
        public String toString() {
            return "Low carb";
        }
    },
    FITNESS {
        @Override
        public String toString() {
            return "Fitness";
        }
    };
}
