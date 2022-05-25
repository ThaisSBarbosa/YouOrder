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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author thais
 */
public class ItemCadastroController implements Initializable {

    @FXML
    private TextField txtDescricao;
    @FXML
    private Button btnRegistrar;
    @FXML
    private ComboBox<?> cbTipo;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnAjuda;
    @FXML
    private TextField txtPreco;
    @FXML
    private PasswordField txtTempo;
    @FXML
    private Label lblErroTempoPrep;
    @FXML
    private Label lblErroDescricao;
    @FXML
    private Label lblErroPreco;
    @FXML
    private Label lblTipo;
    @FXML
    private CheckBox ckAtivo;
    @FXML
    private CheckBox ckVegetariano;
    @FXML
    private CheckBox ckVegano;
    @FXML
    private CheckBox ckIntolLactose;
    @FXML
    private CheckBox ckIntolGluten;
    @FXML
    private CheckBox ckLowCarb;
    @FXML
    private CheckBox ckFitness;
    @FXML
    private ListView<?> listItens;
   
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

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) {
    }

    @FXML
    private void listCardapioOnMouseClicked(MouseEvent event) {
    }

}
