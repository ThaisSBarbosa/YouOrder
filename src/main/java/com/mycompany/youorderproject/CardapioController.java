package com.mycompany.youorderproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


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
public class CardapioController implements Initializable {


    @FXML
    private Button btnAjuda;
    @FXML
    private Button btnVoltar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
