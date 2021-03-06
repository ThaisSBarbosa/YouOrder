/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.ClienteDAO;
import com.mycompany.youorderproject.dao.Conexao;
import com.mycompany.youorderproject.dao.FuncionarioDAO;
import com.mycompany.youorderproject.dao.GerenteDAO;
import com.mycompany.youorderproject.dao.UsuarioDAO;
import com.mycompany.youorderproject.model.Funcionario;
import com.mycompany.youorderproject.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author thais
 */
public class LoginController implements Initializable {

    @FXML
    private Button novoCadastroButton;

    @FXML
    private Button btnAcessar;

    @FXML
    private Label lblEsqueceuASenha;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnAjuda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void switchToNovoCadastro() throws IOException {
        App.exibeTelaDeNovoCadastro();
    }

    @FXML
    private void lblEsqueceuASenhaOnMouseClicked() throws IOException {
        App.exibeTelaRecuperarSenha();
    }

    @FXML
    private void btnAcessarOnMouseClicked() throws IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.validarLogin(txtLogin.getText(), txtSenha.getText());
        if (usuario != null) {
            App.usuarioLogado = usuario;

            ClienteDAO clienteDAO = new ClienteDAO();

            if (clienteDAO.getByUsuario(usuario) != null) {
                App.isGerente = false;
                App.exibeMenuPrincipal();
            } else {
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionario = funcionarioDAO.getByUsuario(usuario);

                if (funcionario != null) {
                    GerenteDAO gerenteDAO = new GerenteDAO();

                    if (gerenteDAO.getByUsuarioFuncionario(usuario, funcionario) != null) {
                        App.isGerente = true;
                        App.exibeMenuPrincipalFuncionario();
                    }
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Usu??rio e/ou senha incorretos");
            alert.setContentText("Por favor, verifique o usu??rio e senha.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeAjuda();
    }
}
