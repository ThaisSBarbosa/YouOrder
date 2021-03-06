package com.mycompany.youorderproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import com.mycompany.youorderproject.dao.ClienteDAO;
import com.mycompany.youorderproject.dao.ItemDAO;
import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.exception.PersistenciaException;
import com.mycompany.youorderproject.model.Item;
import com.mycompany.youorderproject.model.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    @FXML
    private ListView<Object> listCardapio;
    @FXML
    private Label lblItem;
    @FXML
    private Button btnAdicionar;
    @FXML
    private ListView<Object> listSelecionados;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnConfirmarPedido;

    private List<Item> itens;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RestricaoAlimentar restricao = retornaRestricaoClienteLogado();
        BuscaItensCardapio(restricao);
    }

    private RestricaoAlimentar retornaRestricaoClienteLogado() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.getByUsuario(App.usuarioLogado);
        return cliente.getRestricaoAlimentar();
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
        Item itemSelecionado = itens.get(listCardapio.getSelectionModel().getSelectedIndex());

        if (itemSelecionado != null) {
            lblItem.setText(itemSelecionado.getDescricao());
        } else {
            lblItem.setText("-");
        }
    }

    @FXML
    private void btnAdicionarOnMouseClicked(MouseEvent event) {
        AdicionarItem();
    }

    @FXML
    private void btnRemoverOnMouseClicked(MouseEvent event) {
        listSelecionados.getItems().remove(listSelecionados.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void btnConfirmarPedidoOnMouseClicked(MouseEvent event) throws IOException {
        FecharPedido();
    }

    private void AdicionarItem() {
        Item itemSelecionado = itens.get(listCardapio.getSelectionModel().getSelectedIndex());

        if (itemSelecionado != null) {
            listSelecionados.getItems().add(itemSelecionado);
            listSelecionados.scrollTo(listSelecionados.getItems().size() - 1);
        }
    }

    private void FecharPedido() throws IOException {
        App.listItensSelecionados = listSelecionados;
        try {
            ExibirItensDoPedido();
        } catch (IOException ex) {
            Logger.getLogger(CardapioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ExibirItensDoPedido() throws IOException{
        App.exibeTelaPedido();
    }

    private void BuscaItensCardapio(RestricaoAlimentar perfilRestricao) {
        ItemDAO itemDAO = new ItemDAO();
        itens = null;
        
        try {
            if (perfilRestricao == RestricaoAlimentar.SEM_RESTRICAO || perfilRestricao == RestricaoAlimentar.VAZIO || perfilRestricao == null) {
                itens = itemDAO.listar();
            } else {
                itens = itemDAO.listarPorRestricao(perfilRestricao);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(CardapioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        itens.sort(comparing(Item::getTipo));

        int oldTipoItem = -1; //J?? come??ar adicionando o primeiro tipo

        for (Item item : itens.stream().collect(Collectors.toList())) {

            if (oldTipoItem == -1) {
                itens = new ArrayList<>();
            }

            if (oldTipoItem != item.getTipo().ordinal()) {
                oldTipoItem = item.getTipo().ordinal();

                switch (item.getTipo()) {
                    case APERITIVO:
                        listCardapio.getItems().add("*************************APERITIVOS******************************");
                        break;
                    case PRATO_PRINCIPAL:
                        listCardapio.getItems().add("*************************PRATOS PRINCIPAIS*************************");
                        break;
                    case SOBREMESA:
                        listCardapio.getItems().add("*************************SOBREMESAS*************************");
                        break;
                    case BEBIDA:
                        listCardapio.getItems().add("*************************BEBIDAS*************************");
                        break;
                }
                itens.add(null); //Insere como nulo os separadores para se ter controle por ??ndice
            }
            itens.add(item);
            listCardapio.getItems().add(item);
        }
    }

}
