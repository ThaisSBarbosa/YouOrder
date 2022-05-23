/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.youorderproject;

import com.mycompany.youorderproject.dao.ClienteDAO;
import com.mycompany.youorderproject.dao.ItemPedidoDAO;
import com.mycompany.youorderproject.dao.PedidoDAO;
import com.mycompany.youorderproject.enums.StatusPedido;
import com.mycompany.youorderproject.model.Item;
import com.mycompany.youorderproject.model.ItemPedido;
import com.mycompany.youorderproject.model.Pedido;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
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
    
    private List<ItemPedido> itensPedido = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listSelecionados.getItems().addAll(App.listItensSelecionados.getItems());

        for(var obj : App.listItensSelecionados.getItems()){
            Item item = Item.class.cast(obj);
            itensPedido.add(new ItemPedido(0, 0, item.getId(), 1, ""));
        }
        
        atualizaValorTotal();
    }    
    
    @FXML
    private void btnRemoverOnMouseClicked(MouseEvent event) {
        int selectedIndex = listSelecionados.getSelectionModel().getSelectedIndex();
        listSelecionados.getItems().remove(selectedIndex);
        itensPedido.remove(selectedIndex);
        atualizaValorTotal();
        
        selectedIndex = listSelecionados.getSelectionModel().getSelectedIndex();
        ItemPedido itemPedido = itensPedido.get(selectedIndex);
        
        if(itemPedido != null)
            txtObservacao.setText(itemPedido.getObservacao());
    }

    @FXML
    private void btnConfirmarPedidoOnMouseClicked(MouseEvent event) throws IOException, Exception {
        
        ClienteDAO clienteDAO = new ClienteDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
        
        Pedido novoPedido = new Pedido(0,
                clienteDAO.getByUsuario(App.usuarioLogado),
                LocalDateTime.now(),
                null,
                10,
                StatusPedido.PEDIDO_RECEBIDO);
        
        pedidoDAO.inserir(novoPedido);
        
        for(ItemPedido item : itensPedido){
            item.setIdPedido(novoPedido.getId());
        }
        
        itemPedidoDAO.inserirItensPedido(itensPedido);
        
        App.exibeConfirmacaoPedido();
    }

    @FXML
    private void btnAjudaOnMouseClicked(MouseEvent event) throws IOException {
        
        App.exibeTelaDeAjuda();
    }

    @FXML
    private void btnVoltarOnMouseClicked(MouseEvent event) {
        App.popRoot();
    }
    
    private void atualizaValorTotal(){
        double valorTotal = 0;
        
        for(var item : listSelecionados.getItems()){
            valorTotal += Item.class.cast(item).getPreco();
        }
        
        DecimalFormat fmt = new DecimalFormat("0.00");
        lblValorTotal.setText("R$ " + fmt.format(valorTotal));
    }

    @FXML
    private void txtObservacaoOnKeyReleased(KeyEvent event) {
        int selectedIndex = listSelecionados.getSelectionModel().getSelectedIndex();
        itensPedido.get(selectedIndex).setObservacao(txtObservacao.getText());
    }

    @FXML
    private void listSelecionadosOnMouseClicked(MouseEvent event) {
        int selectedIndex = listSelecionados.getSelectionModel().getSelectedIndex();
        ItemPedido itemPedido = itensPedido.get(selectedIndex);
        
        if(itemPedido != null)
            txtObservacao.setText(itemPedido.getObservacao());
    }
}
