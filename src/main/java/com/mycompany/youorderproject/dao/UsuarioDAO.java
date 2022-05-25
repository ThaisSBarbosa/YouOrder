package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class UsuarioDAO implements GenericoDAO<Usuario> {

    public Usuario validarLogin(String username, String senha) {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ? FETCH FIRST 1 ROWS ONLY";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.setString(2, senha);
            pStatement.execute();
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                return new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getString("NOME"),
                        rs.getString("USERNAME"),
                        rs.getString("SENHA"),
                        rs.getTimestamp("ULT_ACESSO").toLocalDateTime(),
                        rs.getTimestamp("DATA_NASC").toLocalDateTime(),
                        rs.getString("ENDERECO"),
                        rs.getString("PERGUNTA_REC"),
                        rs.getString("RESPOSTA_REC"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Boolean buscarUsuario(String username) {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.execute();
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                return true;
            }
            return false;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public String trazerPergunta(String username) {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.execute();
            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("PERGUNTA_REC");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Boolean conferirResposta(String username, String resposta) {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? AND RESPOSTA_REC = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.setString(2, resposta);
            pStatement.execute();
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                return true;
            }
            return false;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public String buscarSenha(String username) {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, username);
            pStatement.execute();
            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                return rs.getString("SENHA");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public List<Usuario> listar() throws PersistenciaException {
        List<Usuario> usuarios = new ArrayList();
        String sql = "SELECT * FROM YOUORDER.USUARIO";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                usuarios.add(new Usuario(
                        result.getInt("ID"),
                        result.getString("NOME"),
                        result.getString("USERNAME"),
                        result.getString("SENHA"),
                        LocalDateTime.parse(result.getString("ULT_ACESSO")),
                        LocalDateTime.parse(result.getString("DATA_NASC")),
                        result.getString("ENDERECO"),
                        result.getString("PERGUNTA_REC"),
                        result.getString("RESPOSTA_REC")
                ));

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }

    @Override
    public void inserir(Usuario usuario) throws PersistenciaException {
        String sql = "INSERT INTO CEFSA.USUARIO(NOME, USERNAME, SENHA, PERGUNTA_REC, RESPOSTA_REC, "
                + "ULT_ACESSO, DATA_NASC, ENDERECO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, usuario.getNome());
            pStatement.setString(2, usuario.getUserName());
            pStatement.setString(3, usuario.getSenha());
            pStatement.setString(4, usuario.getPergunta());
            pStatement.setString(5, usuario.getResposta());
            pStatement.setDate(6, java.sql.Date.valueOf(usuario.getUltimoAcesso().toLocalDate()));
            pStatement.setDate(7, java.sql.Date.valueOf(usuario.getDataNasc().toLocalDate()));
            pStatement.setString(8, String.valueOf(usuario.getEndereco()));
            pStatement.execute();

            try ( ResultSet rs = pStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    usuario.setId(id);
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void alterar(Usuario usuario) throws PersistenciaException {
        String sql = "UPDATE USUARIO SET "
                + "NOME = ?, SENHA = ?, PERGUNTA_REC = ?, RESPOSTA_REC = ?, "
                + "ULT_ACESSO = ?, DATA_NASC = ?, ENDERECO = ? WHERE USERNAME = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getNome());
            pStatement.setString(2, usuario.getSenha());
            pStatement.setString(3, usuario.getPergunta());
            pStatement.setString(4, usuario.getResposta());
            pStatement.setDate(5, java.sql.Date.valueOf(usuario.getUltimoAcesso().toLocalDate()));
            pStatement.setDate(6, java.sql.Date.valueOf(usuario.getDataNasc().toLocalDate()));
            pStatement.setString(7, usuario.getEndereco());
            pStatement.setString(8, usuario.getUserName());
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
        }
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
