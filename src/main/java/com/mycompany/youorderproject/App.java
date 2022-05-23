package com.mycompany.youorderproject;

import com.mycompany.youorderproject.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;
import javafx.scene.control.ListView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;
    private static Scene scene;
    private static Stack<Scene> pilhaTelas;
    public static ListView<Object> listItensSelecionados;
    public static Usuario usuarioLogado;

    static void usuarioLogado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 724, 486);
        pilhaTelas = new Stack<>();
        App.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml, Boolean stackLast) throws IOException {
        if (stackLast) {
            pilhaTelas.push(scene);
        }

        scene = new Scene(loadFXML(fxml), 724, 486);
        stage.setScene(scene);
    }

    static void popRoot() {
        scene = pilhaTelas.pop();
        stage.setScene(scene);
    }

    static void exibeTelaLogin() throws IOException {
        App.setRoot("login", true);
    }

    static void exibeTelaDeAjuda() throws IOException {
        App.setRoot("precisoDeAjuda", true);
    }

    static void exibeMenuPrincipal() throws IOException {
        App.setRoot("menuPrincipal", true);
    }

    static void exibeTelaDeNovoCadastro() throws IOException {
        App.setRoot("novoCadastro", true);
    }

    static void exibeTelaDeAtualizarCadastro() throws IOException {
        App.setRoot("atualizarCadastro", true);
    }

    static void exibeTelaDeCardapio() throws IOException {
        App.setRoot("cardapio", true);
    }

    static void exibeTelaPedido() throws IOException {
        App.setRoot("pedido", true);
    }

    static void exibeTelaRecuperarSenha() throws IOException {
        App.setRoot("recuperarSenha", true);
    }

    static void exibeConfirmacaoPedido() throws IOException {
        App.setRoot("confirmacaoPedido", true);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
