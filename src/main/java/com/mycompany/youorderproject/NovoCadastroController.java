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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnRegistrarOnMouseClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("Registrar novo usuário");
        alert.setContentText("Poxa, essa opção ainda está em desenvolvimento. Aguarde as próximas atualizações.");
        alert.showAndWait();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) throws IOException {
        App.popRoot();
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        //Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("Aviso");
        //alert.setHeaderText("Ajuda");
        //alert.setContentText("Poxa, essa opção ainda está em desenvolvimento. Aguarde as próximas atualizações.");
        //alert.showAndWait();
        App.setRoot("precisoDeAjuda", true);
    }
    
}
