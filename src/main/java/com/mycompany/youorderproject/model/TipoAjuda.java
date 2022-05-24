/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.model;

import java.text.DecimalFormat;

/**
 *
 * @author carlo
 */
public class TipoAjuda {
    
    private int idAjuda;
    private String descricaoAjuda;

    public int getIdAjuda() {
        return idAjuda;
    }

    public void setIdAjuda(int idAjuda) {
        this.idAjuda = idAjuda;
    }

    public String getDescricaoAjuda() {
        return descricaoAjuda;
    }

    public void setDescricaoAjuda(String descricaoAjuda) {
        this.descricaoAjuda = descricaoAjuda;
    }

    public TipoAjuda() {
    }

    public TipoAjuda(int idAjuda, String descricaoAjuda) {
        this.idAjuda = idAjuda;
        this.descricaoAjuda = descricaoAjuda;
    }
    
    @Override
    public String toString() {
        return this.descricaoAjuda;
    }
}
