package br.edu.cefsa.dao;

import br.edu.cefsa.exception.PersistenciaException;
import br.edu.cefsa.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;


public class UsuarioDAO implements GenericoDAO<Usuario> {

    @Override
    public List<Usuario> listar() throws PersistenciaException {
        List<Usuario> usuarios = new ArrayList();
        String sql = "SELECT * FROM YOUORDER.USUARIO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            /*while (result.next()) {
                usuarios.add(new Usuario(
                        result.getInt("ID"),
                        result.getString("EMAIL"),
                        result.getString("SENHA"),
                        LocalDateTime.parse(result.getString("DATACRIACAO")),
                        result.getString("SEXO").charAt(0),
                        result.getString("TIPOUSUARIO").charAt(0)
                ));
            }*/
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
        return usuarios;
    }

    @Override
    public void inserir(Usuario usuario) throws PersistenciaException {
        String sql = "INSERT INTO CEFSA.USUARIO(EMAIL, SENHA, DATACRIACAO, SEXO, TIPOUSUARIO) VALUES (?, ?, ?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            //pStatement.setString(1, usuario.getEmail());
            pStatement.setString(2, usuario.getSenha());
            //pStatement.setDate(3, java.sql.Date.valueOf(usuario.getDataCriacao().toLocalDate()));
            //pStatement.setString(4, String.valueOf(usuario.getSexo()));
            //pStatement.setString(5, String.valueOf(usuario.getTipoUsuario()));
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void alterar(Usuario usuario) throws PersistenciaException {
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
    public void remover(Usuario usuario) throws PersistenciaException {
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
    public Usuario listarPorID(Usuario usuario) throws PersistenciaException {
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

