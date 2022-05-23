package com.mycompany.youorderproject_test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.youorderproject.model.Cliente;
import com.mycompany.youorderproject.enums.RestricaoAlimentar;
import com.mycompany.youorderproject.utils.Constantes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author thais
 */
public class UsuarioTest {

    @Test
    public void usuarioNaoDeveSerCadastradoSemId() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> criaUsuarioSemId()
        );
        Assertions.assertTrue(thrown.getMessage().contains("Não é possível cadastrar cliente com id ou menor que zero."));
        Assertions.assertEquals(thrown.getMessage(), "Não é possível cadastrar cliente com id ou menor que zero.");
    }

    @Test
    public void usuarioNaoDeveSerCadastradoSemNome() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> criaUsuarioSemNome()
        );
        Assertions.assertTrue(thrown.getMessage().contains("Não é possível cadastrar cliente sem nome."));
        Assertions.assertEquals(thrown.getMessage(), "Não é possível cadastrar cliente sem nome.");
    }

    @Test
    public void usernameDeveObedecerLimiteCaracteres() throws Exception {
        try {
            Exception thrown = Assertions.assertThrows(
                    Exception.class,
                    () -> criaUsuarioUsernameMaiorQueLimiteCaracteres()
            );
            Assertions.assertTrue(thrown.getMessage().contains("O username deve ter até " + Constantes.LIMITE_CARACTERES_USERNAME + " caracteres."));
            Assertions.assertEquals(thrown.getMessage(), "O username deve ter até " + Constantes.LIMITE_CARACTERES_USERNAME + " caracteres.");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /////////////////////////////////////////////
    // Construção da massa de dados dos testes.//
    /////////////////////////////////////////////
    private Cliente criaUsuarioFicticio() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 1, "Maria da Silva", "msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345");
    }

    private Cliente criaUsuarioSemId() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 0, "Maria da Silva", "msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345");
    }

    private Cliente criaUsuarioSemNome() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 1, "", "msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345");
    }

    private Cliente criaUsuarioUsernameMaiorQueLimiteCaracteres() throws Exception {
        return new Cliente(RestricaoAlimentar.LOW_CARB, 3, 1, "Maria da Silva", "msilva_msilva", "sgyfdys749",
                LocalDateTime.now(), LocalDateTime.parse("1998-01-26 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                "Rua Serra, 345");
    }
}
