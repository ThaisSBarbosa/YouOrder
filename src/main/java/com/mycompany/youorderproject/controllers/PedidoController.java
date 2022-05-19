/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author carlo
 */
public class PedidoController implements Initializable {


    @FXML
    private ListView<String> listSelecionados;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnConfirmarPedido;
    @FXML
    private TextArea txtObservacao;
    @FXML
    private Button btnAjuda;
    @FXML
    private Button btnVoltar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listSelecionados.getItems().addAll(App.listItensSelecionados.getItems());
    }    
    
    @FXML
    private void btnRemoverOnMouseClicked(MouseEvent event) {
        listSelecionados.getItems().remove(listSelecionados.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void btnConfirmarPedidoOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        
        App.exibeTelaDeAjuda();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) {
        App.popRoot();
    }

}
