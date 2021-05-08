module com.isador.jspe {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.isador.jspe.ui to javafx.fxml;
    exports com.isador.jspe.ui;
}