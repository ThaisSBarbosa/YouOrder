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
import javafx.scene.control.Label;
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

        for (RestricaoAlimentar restricao : RestricaoAlimentar.values()) {
            cbRestricao.getItems().add(restricao.toString());
        }
        cbSexo.getItems().addAll("Masculino", "Feminino", "Prefiro não informar");

        cbRestricao.getSelectionModel().selectFirst();
        cbSexo.getSelectionModel().selectFirst();

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
    private void btnRegistrarOnMouseClicked(MouseEvent event) throws PersistenciaException, Exception {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        if (validaCampos()) {
            lblErroSenha.setVisible(false);
            lblErroNome.setVisible(false);
            lblErroUsername.setVisible(false);
            lblErroDataNascimento.setVisible(false);
            lblErroPergunta.setVisible(false);
            lblErroResposta.setVisible(false);
            lblErroRestricaoAlimentar.setVisible(false);
            lblErroEndereco.setVisible(false);
            
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
    }

    public boolean validaCampos() {
        boolean valido = true;
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (txtNome.getText().isEmpty()) {
            lblErroNome.setText("Preencher o campo");
            lblErroNome.setVisible(true);
            valido = false;
        }

        if (txtUsername.getText().isEmpty()) {
            lblErroUsername.setText("Preencher o campo");
            lblErroUsername.setVisible(true);
            valido = false;
        }

        if (usuarioDAO.buscarUsuario(txtUsername.getText())) {
            lblErroUsername.setText("Username já existe");
            lblErroUsername.setVisible(true);
            valido = false;
        }

        if (!txtSenha.getText().equals(txtConfirmarSenha.getText())) {
            lblErroSenha.setText("As senhas digitadas não conferem");
            lblErroSenha.setVisible(true);
            valido = false;
        }

        if (txtPergunta.getText().isEmpty()) {
            lblErroPergunta.setText("Preencher o campo");
            lblErroPergunta.setVisible(true);
            valido = false;
        }

        if (txtResposta.getText().isEmpty()) {
            lblErroResposta.setText("Preencher o campo");
            lblErroResposta.setVisible(true);
            valido = false;
        }

        if (txtEndereco.getText().isEmpty()) {
            lblErroEndereco.setText("Preencher o campo");
            lblErroEndereco.setVisible(true);
            valido = false;
        }

        if (cbRestricao.getSelectionModel().isSelected(0)) {
            lblErroRestricaoAlimentar.setText("Selecione uma opção");
            lblErroRestricaoAlimentar.setVisible(true);
            valido = false;
        }

        return valido;
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
