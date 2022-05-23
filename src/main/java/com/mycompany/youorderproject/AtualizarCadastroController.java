/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.model.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jessica
 */
public class AtualizarCadastroController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private Button btnAtualizar;
    @FXML
    private ComboBox<?> cbRestricao;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAjuda;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtEndereco;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private ComboBox<?> cbSexo;
    @FXML
    private DatePicker dpNascimento;
    @FXML
    private PasswordField txtConfirmarSenha;
    @FXML
    private TextField txtPergunta;
    @FXML
    private TextField txtResposta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void btnRegistrarOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) {
    }

}
