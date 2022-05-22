/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.Conexao;
import com.mycompany.youorderproject.dao.UsuarioDAO;
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
        UsuarioDAO usuario = new UsuarioDAO();
        if (usuario.validarLogin(txtLogin.getText(), txtSenha.getText())) {
            App.exibeMenuPrincipal();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Usuário e/ou senha incorretos");
            alert.setContentText("Por favor, verifique o usuário e senha.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeAjuda();
    }
}
