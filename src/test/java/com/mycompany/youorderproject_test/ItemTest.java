package com.mycompany.youorderproject_test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.youorderproject.enums.TipoItem;
import com.mycompany.youorderproject.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author thais
 */
public class ItemTest {

    @Test
    public void itemNaoDeveSerCadastradoPrecoZero() throws Exception {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new Item(10, TipoItem.PRATO_PRINCIPAL, 0, "Mega Chicken", true, 10)
        );
        Assertions.assertTrue(thrown.getMessage().contains("O preço do item deve ser maior que zero."));
        Assertions.assertEquals(thrown.getMessage(), "O preço do item deve ser maior que zero.");
    }

    @Test
    public void precoItemNaoDeveSerAlteradoParaZero() throws Exception {
        Item item = new Item(11, TipoItem.PRATO_PRINCIPAL, 20, "Mega Barbecue", true, 11);
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> item.setPreco(0)
        );
        Assertions.assertTrue(thrown.getMessage().contains("O preço do item deve ser maior que zero."));
        Assertions.assertEquals(thrown.getMessage(), "O preço do item deve ser maior que zero.");
    }

    @Test
    public void itemDeveTerDescricaoDiferenteDeVazio() throws Exception {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new Item(55, TipoItem.BEBIDA, 8, "", true, 10)
        );
        Assertions.assertTrue(thrown.getMessage().contains("O item deve conter descrição."));
        Assertions.assertEquals(thrown.getMessage(), "O item deve conter descrição.");
    }

    @Test
    public void alterarTipoItem() throws Exception {
        Item item = new Item(66, TipoItem.APERITIVO, 8, "Vitamina de Banana", true, 10);

        item.setTipo(TipoItem.BEBIDA);
        Assertions.assertEquals(TipoItem.BEBIDA, item.getTipo());

        item.setTipo(TipoItem.PRATO_PRINCIPAL);
        Assertions.assertEquals(TipoItem.PRATO_PRINCIPAL, item.getTipo());

        item.setTipo(TipoItem.SOBREMESA);
        Assertions.assertEquals(TipoItem.SOBREMESA, item.getTipo());
    }
}
