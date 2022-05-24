/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.ClienteDAO;
import com.mycompany.youorderproject.dao.UsuarioDAO;
import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.model.Usuario;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    @FXML
    private Label lblErroNome;
    @FXML
    private Label lblErroUsername;
    @FXML
    private Label lblErroDataNascimento;
    @FXML
    private Label lblErroSenha;
    @FXML
    private Label lblErroPergunta;
    @FXML
    private Label lblErroResposta;
    @FXML
    private Label lblErroEndereco;
    @FXML
    private Label lblErroRestricaoAlimentar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtNome.setText(App.usuarioLogado.getNome());
        txtUsername.setText(App.usuarioLogado.getUserName());
        txtSenha.setText(App.usuarioLogado.getSenha());
        txtConfirmarSenha.setText(App.usuarioLogado.getSenha());
        txtPergunta.setText(App.usuarioLogado.getPergunta());
        txtResposta.setText(App.usuarioLogado.getResposta());
        txtEndereco.setText(App.usuarioLogado.getEndereco());

        lblErroSenha.setVisible(false);
        lblErroNome.setVisible(false);
        lblErroUsername.setVisible(false);
        lblErroDataNascimento.setVisible(false);
        lblErroPergunta.setVisible(false);
        lblErroResposta.setVisible(false);
        lblErroRestricaoAlimentar.setVisible(false);
        lblErroEndereco.setVisible(false);

    }

    @FXML
    private void btnRegistrarOnMouseClicked(MouseEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Criação de usuário");
        alert.setContentText("O usuário foi criado com sucesso. Agora é só fazer o login!");
        alert.showAndWait();
        App.popRoot();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) {
    }

}
