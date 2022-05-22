/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Jessica
 */
public class RecuperarSenhaController implements Initializable {

    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblPergunta;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtResposta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnEnviarOnMouseClicked(MouseEvent event) throws IOException {
        UsuarioDAO usuario = new UsuarioDAO();
        if (usuario.conferirResposta(txtUsername.getText(), txtResposta.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Recuperação de Senha");
            alert.setHeaderText("Recuperação de Senha");
            alert.setContentText("A sua senha é " + usuario.buscarSenha(txtUsername.getText()));
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro");
            alert.setContentText("Não foi possível recuperar a sua senha.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnTrazerPerguntaOnMouseClicked(MouseEvent event) {
        UsuarioDAO usuario = new UsuarioDAO();
        if (usuario.buscarUsuario(txtUsername.getText())) {
            lblPergunta.setText(usuario.trazerPergunta(txtUsername.getText()));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("teste");
            alert.setHeaderText("teste");
            alert.setContentText("teste");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaLogin();
    }
}
