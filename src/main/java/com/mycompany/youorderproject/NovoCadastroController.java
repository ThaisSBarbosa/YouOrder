/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.ClienteDAO;
import com.mycompany.youorderproject.dao.UsuarioDAO;
import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    private TextField txtEndereco;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private ComboBox<String> cbSexo;
    @FXML
    private TextField txtUsername;
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

        for (RestricaoAlimentar restricao : RestricaoAlimentar.values()) {
            cbRestricao.getItems().add(restricao.toString());
        }
        cbSexo.getItems().addAll("Masculino", "Feminino", "Prefiro não informar");

        cbRestricao.getSelectionModel().selectFirst();
        cbSexo.getSelectionModel().selectFirst();
    }

    @FXML
    private void btnRegistrarOnMouseClicked(MouseEvent event) throws PersistenciaException, Exception {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        if(!txtSenha.getText().equals(txtConfirmarSenha.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Confirmação de senha");
            alert.setContentText("As senhas digitadas não conferem. Por favor verifique as senhas e tente novamente.");
            alert.showAndWait();
            
            return;
        }

        
        Usuario novoUsuario = new Usuario(
                1,
                txtNome.getText(), 
                txtUsername.getText(),
                txtSenha.getText(), 
                LocalDateTime.now(), 
                dpNascimento.getValue().atStartOfDay(),
                txtEndereco.getText(),
                txtPergunta.getText(),
                txtResposta.getText());

        usuarioDAO.inserir(novoUsuario);
        
        Cliente novoCliente = new Cliente(0, novoUsuario, RestricaoAlimentar.values()[cbRestricao.getSelectionModel().getSelectedIndex()], 0);
        
        clienteDAO.inserir(novoCliente);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText("Criação de usuário");
            alert.setContentText("O usuário foi criado com sucesso. Agora é só fazer o login!");
            alert.showAndWait();
            App.popRoot();
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
