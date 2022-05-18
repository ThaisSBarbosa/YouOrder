/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author carlo
 */
public class CardapioController implements Initializable {

    @FXML
    private Button btnAjuda;
    @FXML
    private Button btnVoltar;
    @FXML
    private ListView<String> listCardapio;
    @FXML
    private Label lblItem;
    @FXML
    private Button btnAdicionar;
    @FXML
    private ListView<String> listSelecionados;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnConfirmarPedido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Feijão");
        listCardapio.getItems().add("Macarrão");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
        listCardapio.getItems().add("Arroz");
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeAjuda();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) {
        App.popRoot();
    }

    @FXML
    private void listCardapioOnMouseClicked(MouseEvent event) {
        lblItem.setText(listCardapio.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void btnAdicionarOnMouseClicked(MouseEvent event) {
        listSelecionados.getItems().add(lblItem.getText());
        listSelecionados.scrollTo(listSelecionados.getItems().size() - 1);
    }

    @FXML
    private void btnRemoverOnMouseClicked(MouseEvent event) {
        listSelecionados.getItems().remove(listSelecionados.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void btnConfirmarPedidoOnMouseClicked(MouseEvent event) throws IOException {
        App.listItensSelecionados = listSelecionados;
        App.exibeTelaPedido();
    }

}
