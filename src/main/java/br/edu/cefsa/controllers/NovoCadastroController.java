/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.cefsa.controllers;

import br.edu.cefsa.dao.UsuarioDAO;
import br.edu.cefsa.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author thais
 */
public class NovoCadastroController implements Initializable {

    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAjuda;
    @FXML
    private TextField txtNome;
    @FXML
    private ComboBox<String> cbRestricao;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEndereco;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private ComboBox<String> cbSexo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbRestricao.getItems().addAll("Sem restrição", "Vegetariano", "Vegano");
        cbSexo.getItems().addAll("Masculino", "Feminino", "Prefiro não informar");
        
        cbRestricao.getSelectionModel().selectFirst();
        cbSexo.getSelectionModel().selectFirst();
    }    

    @FXML
    private void btnRegistrarOnMouseClicked(MouseEvent event) throws PersistenciaException {
        Usuario novoUsuario = new Usuario(
                0, 
                txtEmail.getText(), 
                txtSenha.getText(), 
                LocalDateTime.now(), 
                cbSexo.getSelectionModel().getSelectedItem().charAt(0), 
                'C');
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuarioDAO.inserir(novoUsuario);
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) throws IOException {
        App.popRoot();
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeAjuda();
    }
    
}
