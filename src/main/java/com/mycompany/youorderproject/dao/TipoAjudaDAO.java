/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.TipoAjuda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class TipoAjudaDAO implements GenericoDAO<TipoAjuda> {

    @Override
    public List<TipoAjuda> listar() throws PersistenciaException {
        List<TipoAjuda> tiposAjuda = new ArrayList();
        String sql = "SELECT * FROM CEFSA.TIPO_AJUDA";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                tiposAjuda.add(new TipoAjuda(
                        result.getInt("ID_AJUDA"),
                        result.getString("DESC_AJUDA")
                ));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TipoAjudaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TipoAjudaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TipoAjudaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoAjudaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tiposAjuda;
    }

    @Override
    public void inserir(TipoAjuda tipoAjuda) throws PersistenciaException {
        
    }

    @Override
    public void alterar(TipoAjuda pedido) throws PersistenciaException {

    }

    @Override
    public void remover(TipoAjuda pedido) throws PersistenciaException {

    }

    @Override
    public TipoAjuda listarPorID(TipoAjuda pedido) throws PersistenciaException {
        return null;
    }
}
