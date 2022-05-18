module com.mycompany.youorderproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.youorderproject to javafx.fxml;
    exports com.mycompany.youorderproject;
}
