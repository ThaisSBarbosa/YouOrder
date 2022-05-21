/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Jessica
 */
public class RecuperarSenhaController implements Initializable {


    @FXML
    private Pane txtPergunta;
    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblPergunta;
    @FXML
    private TextField txtResposta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnRegistrarOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) {
    }

}
