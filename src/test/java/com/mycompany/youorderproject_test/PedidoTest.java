package com.mycompany.youorderproject_test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.enums.TipoItem;
import com.mycompany.youorderproject.enums.StatusPedido;
import com.mycompany.youorderproject.model.Item;
import com.mycompany.youorderproject.model.Pedido;
import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.utils.Constantes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author thais
 */
public class PedidoTest {

    private final ArrayList<Item> itens;
    private final Cliente cliente;
    private final Pedido pedidoComItens;
    private final Pedido pedidoComClienteComQtdDescontoFidelidade;

    public PedidoTest() throws Exception {
        this.itens = criaItensFicticios();
        this.cliente = criaClienteFicticio();
        this.pedidoComItens = criaPedidoComItens();
        this.pedidoComClienteComQtdDescontoFidelidade = criaPedidoComClienteComQtdDescontoFidelidade();
    }

//    @Test
//    public void pedidoNaoDeveTerZeroItens() {
//        Assertions.assertNotEquals(pedidoComItens.getItens().size(), 0);  
//        
//        Exception thrown = Assertions.assertThrows(
//                Exception.class,
//                () -> criaPedidoSemItens()
//        );
//        Assertions.assertTrue(thrown.getMessage().contains("O pedido deve conter ao menos um item."));
//        Assertions.assertEquals(thrown.getMessage(), "O pedido deve conter ao menos um item.");
//    }
//    @Test
//    public void aplicarDescontoFidelidade() throws Exception {
//        double valorAnteriorDoPedido = 27;
//        double valorComDesconto = valorAnteriorDoPedido - Constantes.VALOR_DESCONTO_FIDELIDADE;
//
//        Assertions.assertEquals(valorComDesconto, pedidoComClienteComQtdDescontoFidelidade.getValor());
//    }

//    @Test
//    public void aposDescontoFidelidadeZeraAQtdPedidosFidelidade() throws Exception {
//        Assertions.assertTrue(pedidoComClienteComQtdDescontoFidelidade.getCliente().getQtdPedidosFidelidade() == 0);
//    }

    @Test
    public void dataInicioDeveSerMaiorQueDataFinal() {
        pedidoComItens.setDataFinal(LocalDateTime.parse("2022-05-15 01:15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        pedidoComItens.setStatus(StatusPedido.PEDIDO_ENTREGUE);
        double tempoPedido = ChronoUnit.MINUTES.between(pedidoComItens.getDataInicio(), pedidoComItens.getDataFinal());

        // A diferença não deve ser menor que zero minutos.
        Assertions.assertFalse(tempoPedido <= 0);
    }

    @Test
    public void alterarStatusPedido() throws Exception {
        pedidoComItens.setStatus(StatusPedido.PEDIDO_ENTREGUE);
        Assertions.assertEquals(StatusPedido.PEDIDO_ENTREGUE, pedidoComItens.getStatus());

        pedidoComItens.setStatus(StatusPedido.PEDIDO_FILA);
        Assertions.assertEquals(StatusPedido.PEDIDO_FILA, pedidoComItens.getStatus());

        pedidoComItens.setStatus(StatusPedido.PEDIDO_PRONTO);
        Assertions.assertEquals(StatusPedido.PEDIDO_PRONTO, pedidoComItens.getStatus());
    }

    @Test
    public void pedidoNaoDeveSerCadastradoSemNumeroDaMesa() throws Exception {
        Assertions.assertNotEquals(pedidoComItens.getNumeroMesa(), 0);

        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> criaPedidoSemMesa()
        );
        Assertions.assertTrue(thrown.getMessage().contains("O pedido deve conter número da mesa."));
        Assertions.assertEquals(thrown.getMessage(), "O pedido deve conter número da mesa.");
    }

    @Test
    public void pedidoNaoDeveSerCadastradoSemCliente() throws Exception {
        Assertions.assertNotSame(pedidoComItens.getCliente(), null);
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> criaPedidoSemCliente()
        );
        Assertions.assertTrue(thrown.getMessage().contains("O pedido deve conter um cliente cadastrado."));
        Assertions.assertEquals(thrown.getMessage(), "O pedido deve conter um cliente cadastrado.");
    }

    @Test
    public void dataInicioDeveSerMenorOuIgualQueDataAtual() {
        double tempoDiferenca = ChronoUnit.MINUTES.between(pedidoComItens.getDataInicio(), LocalDateTime.now());

        // A diferença deve ser maior que zero minutos.
        Assertions.assertTrue(tempoDiferenca > 0);
    }

    /////////////////////////////////////////////
    // Construção da massa de dados dos testes.//
    /////////////////////////////////////////////
    private ArrayList<Item> criaItensFicticios() throws Exception {
        ArrayList<Item> itensFicticios = new ArrayList<Item>();

        itensFicticios.add(new Item(99, TipoItem.PRATO_PRINCIPAL, 20, "Mega Barbecue", true, 10));
        itensFicticios.add(new Item(88, TipoItem.BEBIDA, 20, "Suco de Laranja", true, 10));
        itensFicticios.add(new Item(77, TipoItem.SOBREMESA, 20, "Mousse de Morango", true, 10));

        return itensFicticios;
    }

    private Cliente criaClienteFicticio() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 1, "Maria da Silva", "msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345", "pergunta", "resposta");
    }

    private Cliente criaClienteComQtdFidelidade() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 5, 1, "Maria da Silva", "msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345", "pergunta", "resposta");
    }

    private Pedido criaPedidoComItens() throws Exception {
        return new Pedido(1, cliente,/* itens,*/ LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                15, StatusPedido.PEDIDO_ENTREGUE);
    }

    private Pedido criaPedidoSemItens() throws Exception {
        return new Pedido(2, cliente/*, new ArrayList<Item>()*/, LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                15, StatusPedido.PEDIDO_ENTREGUE);
    }

    private Pedido criaPedidoSemMesa() throws Exception {
        return new Pedido(3, cliente,/* itens,*/ LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                0, StatusPedido.PEDIDO_ENTREGUE);
    }

    private Pedido criaPedidoSemCliente() throws Exception {
        return new Pedido(4, null,/* itens,*/ LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                15, StatusPedido.PEDIDO_ENTREGUE);
    }

    private Pedido criaPedidoComClienteComQtdDescontoFidelidade() throws Exception {
        return new Pedido(5, criaClienteComQtdFidelidade(),/* itens,*/ LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                15, StatusPedido.PEDIDO_ENTREGUE);
    }
}
