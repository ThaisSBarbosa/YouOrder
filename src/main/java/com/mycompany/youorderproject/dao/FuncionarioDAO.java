/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.model.Funcionario;
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

/**
 *
 * @author carlo
 */
public class FuncionarioDAO implements GenericoDAO<Funcionario> {

    @Override
    public List<Funcionario> listar() throws PersistenciaException {
        return null;
    }

    @Override
    public void inserir(Funcionario funcionario) throws PersistenciaException {
    }

    @Override
    public void alterar(Funcionario funcionario) throws PersistenciaException {
    }

    @Override
    public void remover(Funcionario funcionario) throws PersistenciaException {
    }

    @Override
    public Funcionario listarPorID(Funcionario funcionario) throws PersistenciaException {
        return null;
    }
    
    public Funcionario getByUsuario(Usuario usuario){
        String sql = "SELECT * FROM FUNCIONARIO WHERE ID_USUARIO = ? FETCH FIRST 1 ROWS ONLY";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, usuario.getId());
            pStatement.execute();

            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                return new Funcionario(
                        rs.getInt("ID_FUNCIONARIO"),
                        LocalDateTime.parse(rs.getDate("DATA_CONTRATACAO").toLocalDate().atStartOfDay().toString()),
                        usuario);
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
}
