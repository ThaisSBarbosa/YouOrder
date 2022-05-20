/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.enums.PrecisoDeAjuda;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author carlo
 */
public class PrecisoDeAjudaController implements Initializable {

    @FXML
    private Button btnEnviar;
    @FXML
    private Button btnVoltar;
    @FXML
    private ComboBox<String> cbAjuda;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (PrecisoDeAjuda ajuda : PrecisoDeAjuda.values()) {
            cbAjuda.getItems().add(ajuda.toString());
        }
    }    

    @FXML
    private void btnEnviarOnMouseClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Preciso de Ajuda");
        alert.setHeaderText("A sua solicitação foi enviada. Por favor, aguardar");
        alert.showAndWait();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) throws IOException {
        App.popRoot();
    }
}