/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.exception.PersistenciaException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface GenericoDAO<E> extends Serializable {

    List<E> listar() throws PersistenciaException;

    void inserir(E e) throws PersistenciaException;

    void alterar(E e) throws PersistenciaException;

    void remover(E e) throws PersistenciaException;

    E listarPorID(E e) throws PersistenciaException;
}
