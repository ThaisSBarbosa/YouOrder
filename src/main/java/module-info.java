module com.mycompany.youorderproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires org.junit.jupiter.api;

    opens br.edu.cefsa to javafx.fxml;
    exports br.edu.cefsa.controllers;
}
