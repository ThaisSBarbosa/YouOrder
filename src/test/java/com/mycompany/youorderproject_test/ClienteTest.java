package com.mycompany.youorderproject_test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author thais
 */
public class ClienteTest {

    @Test
    public void alterarRestricaoAlimentar() throws Exception {
        var cliente = criaClienteFicticio();

        cliente.setRestricaoAlimentar(RestricaoAlimentar.VEGETARIANO);
        Assertions.assertEquals(RestricaoAlimentar.VEGETARIANO, cliente.getRestricaoAlimentar());

        cliente.setRestricaoAlimentar(RestricaoAlimentar.FITNESS);
        Assertions.assertEquals(RestricaoAlimentar.FITNESS, cliente.getRestricaoAlimentar());

        cliente.setRestricaoAlimentar(RestricaoAlimentar.VEGANO);
        Assertions.assertEquals(RestricaoAlimentar.VEGANO, cliente.getRestricaoAlimentar());
    }

    /////////////////////////////////////////////
    // Construção da massa de dados dos testes.//
    /////////////////////////////////////////////
    private Cliente criaClienteFicticio() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 1, "Maria da Silva", "msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345", "pergunta", "resposta");
    }
}
