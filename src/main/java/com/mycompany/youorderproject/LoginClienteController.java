/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author thais
 */
public class LoginClienteController implements Initializable {


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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToNovoCadastro() throws IOException {
        App.setRoot("novoCadastro");
    }
    
    @FXML
    private void lblEsqueceuASenhaOnMouseClicked() throws IOException {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("Esqueceu a senha?");
        alert.setContentText("Poxa, essa opção ainda está em desenvolvimento. Aguarde as próximas atualizações.");
        alert.showAndWait();
    }
    
    @FXML
    private void btnAcessarOnMouseClicked() throws IOException {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("Acesso ao Login");
        alert.setContentText("Poxa, essa opção ainda está em desenvolvimento. Aguarde as próximas atualizações.");
        alert.showAndWait();
    }
}
