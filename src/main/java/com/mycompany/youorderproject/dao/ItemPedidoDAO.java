/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.enums.StatusPedido;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.ItemPedido;
import com.mycompany.youorderproject.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ItemPedidoDAO implements GenericoDAO<ItemPedido> {

    @Override
    public List<ItemPedido> listar() throws PersistenciaException {
        return null;
    }

    @Override
    public void inserir(ItemPedido item) throws PersistenciaException {
        String sql = "INSERT INTO CEFSA.ITEM_PEDIDO(ID_PEDIDO, ID_ITEM, QTD_ITEM, OBSERVACAO) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStatement.setInt(1, item.getIdPedido());
            pStatement.setInt(2, item.getIdItem());
            pStatement.setInt(3, item.getQtdItem());
            pStatement.setString(4, item.getObservacao());
            pStatement.execute();
            
            try (ResultSet rs = pStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        item.setId(id);
                    }
                }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(PedidoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void alterar(ItemPedido itemPedido) throws PersistenciaException {

    }

    @Override
    public void remover(ItemPedido itemPedido) throws PersistenciaException {

    }

    @Override
    public ItemPedido listarPorID(ItemPedido itemPedido) throws PersistenciaException {
        return null;
    }
    
    public void inserirItensPedido(List<ItemPedido> itensPedido) throws PersistenciaException{
        for(ItemPedido itemPedido : itensPedido){
            inserir(itemPedido);
        }
    }
}
