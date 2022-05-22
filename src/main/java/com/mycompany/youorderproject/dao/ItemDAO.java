/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.enums.TipoItem;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Item;
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
public class ItemDAO implements GenericoDAO<Item> {

    @Override
    public List<Item> listar() throws PersistenciaException {
        List<Item> itens = new ArrayList();
        String sql = "SELECT * FROM CEFSA.ITEM";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                itens.add(new Item(
                        result.getInt("ID_ITEM"),
                        TipoItem.values()[result.getInt("TIPO_ITEM")],
                        result.getDouble("PRECO"),
                        result.getString("DESCRICAO"),
                        result.getString("ATIVO_CARDAPIO").charAt(0) == 'S',
                        result.getInt("TEMPO_ESTIMADO")
                ));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return itens;
    }

    @Override
    public void inserir(Item item) throws PersistenciaException {
        
    }

    @Override
    public void alterar(Item item) throws PersistenciaException {

    }

    @Override
    public void remover(Item item) throws PersistenciaException {

    }

    @Override
    public Item listarPorID(Item item) throws PersistenciaException {
        return null;
    }
}
