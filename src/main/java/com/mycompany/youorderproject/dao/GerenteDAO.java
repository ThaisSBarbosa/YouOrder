/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.youorderproject.dao;

import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.model.Funcionario;
import com.mycompany.youorderproject.model.Gerente;
import com.mycompany.youorderproject.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class GerenteDAO implements GenericoDAO<Gerente> {

    @Override
    public List<Gerente> listar() throws PersistenciaException {
        return null;
    }

    @Override
    public void inserir(Gerente gerente) throws PersistenciaException {
        
    }

    @Override
    public void alterar(Gerente gerente) throws PersistenciaException {

    }

    @Override
    public void remover(Gerente gerente) throws PersistenciaException {
        
    }

    @Override
    public Gerente listarPorID(Gerente gerente) throws PersistenciaException {
        return null;
    }
    
    public Gerente getByUsuarioFuncionario(Usuario usuario, Funcionario funcionario){
        String sql = "SELECT * FROM GERENTE WHERE ID_FUNCIONARIO = ? FETCH FIRST 1 ROWS ONLY";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, funcionario.getIdFuncionario());
            pStatement.execute();

            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                return new Gerente(rs.getInt("ID_GERENTE"), funcionario, usuario);
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