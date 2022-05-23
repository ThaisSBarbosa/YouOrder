/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.enums.StatusPedido;
import com.mycompany.youorderproject.enums.TipoItem;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Item;
import com.mycompany.youorderproject.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class PedidoDAO implements GenericoDAO<Pedido> {

    @Override
    public List<Pedido> listar() throws PersistenciaException {
        return null;
    }

    @Override
    public void inserir(Pedido pedido) throws PersistenciaException {
        String sql = "INSERT INTO CEFSA.PEDIDO(ID_CLIENTE, INICIO, NUM_MESA, STATUS) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStatement.setInt(1, pedido.getCliente().getIdCliente());
            pStatement.setTimestamp(2, Timestamp.from(Instant.now()));
            pStatement.setInt(3, pedido.getNumeroMesa());
            pStatement.setInt(4, StatusPedido.PEDIDO_RECEBIDO.ordinal());
            pStatement.execute();
            
            try (ResultSet rs = pStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        pedido.setId(id);
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
    public void alterar(Pedido pedido) throws PersistenciaException {

    }

    @Override
    public void remover(Pedido pedido) throws PersistenciaException {

    }

    @Override
    public Pedido listarPorID(Pedido pedido) throws PersistenciaException {
        return null;
    }
}