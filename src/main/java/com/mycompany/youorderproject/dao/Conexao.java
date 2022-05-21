package com.mycompany.youorderproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Carlos
 */
public class Conexao {

    //private final ResourceBundle BUNDLE = ResourceBundle.getBundle("derb", new Locale("pt", "BR"));
    public static Conexao conexao;

    public Conexao() {
        
    }

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        //Connection connection = DriverManager.getConnection(BUNDLE.getString("url"), BUNDLE.getString("usuario"), BUNDLE.getString("senha"));
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/youorder", "cefsa", "cefsa");
        return connection;
    }
}
