/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.TipoAjudaDAO;
import com.mycompany.youorderproject.enums.PrecisoDeAjuda;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.TipoAjuda;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ComboBox<TipoAjuda> cbAjuda;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<TipoAjuda> tiposAjuda = new ArrayList<>();
        TipoAjudaDAO tipoAjudaDAO = new TipoAjudaDAO();
        
        try {
            tiposAjuda = tipoAjudaDAO.listar();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PrecisoDeAjudaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (TipoAjuda ajuda : tiposAjuda) {
            cbAjuda.getItems().add(ajuda);
        }
    }    

    @FXML
    private void btnEnviarOnMouseClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Preciso de Ajuda");
        alert.setHeaderText("Agora é só aguardar. Um atendente virá falar com você.");
        alert.showAndWait();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) throws IOException {
        App.popRoot();
    }
}