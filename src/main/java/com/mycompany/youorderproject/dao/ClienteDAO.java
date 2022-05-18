package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO implements GenericoDAO<Cliente> {

    @Override
    public List<Cliente> listar() throws PersistenciaException {
        List<Cliente> clientes = new ArrayList();
        String sql = "SELECT * FROM YOUORDER.CLIENTE";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                clientes.add(new Cliente(
                        result.getInt("ID"),
                        result.getString("NOME"),
                        LocalDate.parse(result.getString("DATANASCIMENTO")),
                        result.getString("ENDERECO"),
                        result.getInt("PERFILRESTRICAO"),
                        result.getInt("QTDPEDIDOSFIDELIDADE")
                ));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }

    @Override
    public void inserir(Cliente cliente) throws PersistenciaException {
        String sql = "INSERT INTO YOUORDER.CLIENTE (ID, NOME, DATANASCIMENTO, ENDERECO, PERFILRESTRICAO, QTDPEDIDOSFIDELIDADE) VALUES (?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, cliente.getId());
            pStatement.setString(2, cliente.getNome());
            pStatement.setString(3, cliente.getDataNascimento().toString());
            pStatement.setString(4, cliente.getEndereco());
            pStatement.setInt(5, cliente.getPerfilRestricao());
            pStatement.setInt(6, cliente.getQtdPedidosFidelidade());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) throws PersistenciaException {
        /*String sql = "UPDATE EMPRESA.CARGO SET NOME=? WHERE ID_CARGO = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getNome());
            pStatement.setLong(2, usuario.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }

    @Override
    public void remover(Cliente cliente) throws PersistenciaException {
        /*String sql = "DELETE FROM EMPRESA.CARGO WHERE ID_CARGO = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, usuario.getCodigo());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível conectar à base de dados!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível enviar o comando para a base de dados!");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }

    @Override
    public Cliente listarPorID(Cliente cliente) throws PersistenciaException {
        /*String sql = "SELECT * FROM EMPRESA.CARGO WHERE ID_CARGO = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, usuario.getCodigo());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                usuario.setCodigo(result.getLong("ID_CARGO"));
                usuario.setNome(result.getString("NOME"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;*/
        return null;
    }
}

