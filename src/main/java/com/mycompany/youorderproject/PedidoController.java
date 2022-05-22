/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.model.Item;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author carlo
 */
public class PedidoController implements Initializable {

    //teste

    @FXML
    private ListView<Object> listSelecionados;
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
    @FXML
    private Label lblValorTotal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listSelecionados.getItems().addAll(App.listItensSelecionados.getItems());
        
        double valorTotal = 0;
        
        for(var item : listSelecionados.getItems()){
            valorTotal += Item.class.cast(item).getPreco();
        }
        
        DecimalFormat fmt = new DecimalFormat("0.00");
        lblValorTotal.setText("R$ " + fmt.format(valorTotal));
    }    
    
    @FXML
    private void btnRemoverOnMouseClicked(MouseEvent event) {
        listSelecionados.getItems().remove(listSelecionados.getSelectionModel().getSelectedIndex());
        
        double valorTotal = 0;
        
        for(var item : listSelecionados.getItems()){
            valorTotal += Item.class.cast(item).getPreco();
        }
        
        DecimalFormat fmt = new DecimalFormat("0.00");
        lblValorTotal.setText("R$ " + fmt.format(valorTotal));
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
