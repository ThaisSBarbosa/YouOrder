/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.youorderproject_test;

import br.edu.cefsa.entities.Cliente;
import br.edu.cefsa.enums.TipoItem;
import br.edu.cefsa.enums.StatusPedido;
import br.edu.cefsa.entities.Item;
import br.edu.cefsa.entities.Pedido;
import br.edu.cefsa.enums.RestricaoAlimentar;
import br.edu.cefsa.utils.Constantes;
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

    public PedidoTest() throws Exception{
        this.itens = criaItensFicticios();
        this.cliente = criaClienteFicticio();
        this.pedidoComItens = criaPedidoComItens();
        this.pedidoComClienteComQtdDescontoFidelidade = criaPedidoComClienteComQtdDescontoFidelidade();
    }

    @Test
    public void pedidoNaoDeveTerZeroItens() {
        Assertions.assertNotEquals(pedidoComItens.getItens().size(), 0);  
        
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> criaPedidoSemItens()
        );
        Assertions.assertTrue(thrown.getMessage().contains("O pedido deve conter ao menos um item."));
        Assertions.assertEquals(thrown.getMessage(), "O pedido deve conter ao menos um item.");
    }
    
    @Test
    public void aplicarDescontoFidelidade() throws Exception{        
        double valorAnteriorDoPedido = 27;
        double valorComDesconto = valorAnteriorDoPedido - Constantes.VALOR_DESCONTO_FIDELIDADE;
   
        Assertions.assertEquals(valorComDesconto, pedidoComClienteComQtdDescontoFidelidade.getValor());
    }
    
    @Test
    public void aposDescontoFidelidadeZeraAQtdPedidosFidelidade() throws Exception{        
        Assertions.assertTrue(pedidoComClienteComQtdDescontoFidelidade.getCliente().getQtdPedidosFidelidade() == 0);
    }
    
    @Test
    public void dataInicioDeveSerMaiorQueDataFinal() {
        pedidoComItens.setDataFinal(LocalDateTime.parse("2022-05-15 01:15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        pedidoComItens.setStatus(StatusPedido.CONCLUIDO);        
        double tempoPedido = ChronoUnit.MINUTES.between(pedidoComItens.getDataInicio(), pedidoComItens.getDataFinal());
        
        // A diferença não deve ser menor que zero minutos.
        Assertions.assertFalse(tempoPedido <= 0);
    }
    
    @Test
    public void alterarStatusPedido() throws Exception{
        pedidoComItens.setStatus(StatusPedido.PENDENTE_DE_CONFIRMACAO);
        Assertions.assertEquals(StatusPedido.PENDENTE_DE_CONFIRMACAO, pedidoComItens.getStatus());
        
        pedidoComItens.setStatus(StatusPedido.EM_PREPARO);
        Assertions.assertEquals(StatusPedido.EM_PREPARO, pedidoComItens.getStatus());
        
        pedidoComItens.setStatus(StatusPedido.PAGO);
        Assertions.assertEquals(StatusPedido.PAGO, pedidoComItens.getStatus());
    }
    
    @Test
    public void pedidoNaoDeveSerCadastradoSemNumeroDaMesa() throws Exception{
        Assertions.assertNotEquals(pedidoComItens.getNumeroMesa(), 0);  
        
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> criaPedidoSemMesa()
        );
        Assertions.assertTrue(thrown.getMessage().contains("O pedido deve conter número da mesa."));
        Assertions.assertEquals(thrown.getMessage(), "O pedido deve conter número da mesa.");
    }
    
    @Test
    public void pedidoNaoDeveSerCadastradoSemCliente() throws Exception{
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

        itensFicticios.add(new Item(TipoItem.PRATO_PRINCIPAL, 20, "Mega Barbecue", true, 10, 1));
        itensFicticios.add(new Item(TipoItem.BEBIDA, 20, "Suco de Laranja", true, 10, 1));
        itensFicticios.add(new Item(TipoItem.SOBREMESA, 20, "Mousse de Morango", true, 10, 1));

        return itensFicticios;
    }
    
    private Cliente criaClienteFicticio() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 1, "Maria da Silva", "msilva", "sgyfdys749",
                                        LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 
                                        "Rua Serra, 345");
    }
    
    private Cliente criaClienteComQtdFidelidade() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 5, 1, "Maria da Silva", "msilva", "sgyfdys749",
                                        LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 
                                        "Rua Serra, 345");
    }

    private Pedido criaPedidoComItens() throws Exception{
        return new Pedido(cliente, itens, LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                            15, StatusPedido.EM_PREPARO, 23);
    }
    
    private Pedido criaPedidoSemItens() throws Exception{
        return new Pedido(cliente, new ArrayList<Item>(), LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                            15, StatusPedido.EM_PREPARO, 23);
    }
    
    private Pedido criaPedidoSemMesa() throws Exception{
        return new Pedido(cliente, itens, LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                            0, StatusPedido.EM_PREPARO, 23);
    }
    
    private Pedido criaPedidoSemCliente() throws Exception{
        return new Pedido(null, itens, LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                            15, StatusPedido.EM_PREPARO, 23);
    }
    
    private Pedido criaPedidoComClienteComQtdDescontoFidelidade() throws Exception{
        return new Pedido(criaClienteComQtdFidelidade(), itens, LocalDateTime.parse("2022-05-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), null,
                            15, StatusPedido.EM_PREPARO, 27);
    }
}
