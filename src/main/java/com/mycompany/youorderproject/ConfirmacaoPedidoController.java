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
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author carlo
 */
public class ConfirmacaoPedidoController implements Initializable {

    @FXML
    private Button btnVoltarAoMenu;
    @FXML
    private Button btnAjuda;
    @FXML
    private ComboBox<?> cbSexo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void btnVoltarAoMenuOnMouseClicked(MouseEvent event) {
        App.popRoot();
        App.popRoot();
        App.popRoot();
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        App.exibeTelaDeAjuda();
    }
    
}
