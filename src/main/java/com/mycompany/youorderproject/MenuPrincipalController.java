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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author carlo
 */
public class MenuPrincipalController implements Initializable {

    @FXML
    private Button btnAtualizarCadastro;
    @FXML
    private Button btnHistoricoPedidos;
    @FXML
    private Button btnMeusFavoritos;
    @FXML
    private Button btnNovoPedido;
    @FXML
    private Button btnAjuda;
    @FXML
    private Button btnSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAtualizarCadastroOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaAtualizarCadastro();
    }

    @FXML
    private void btnHistoricoPedidosOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnMeusFavoritosOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnNovoPedidoOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeCardapio();
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeAjuda();
    }

    @FXML
    private void btnSairOnMouseClicked(MouseEvent event) {
        App.popRoot();
    }
    
}
