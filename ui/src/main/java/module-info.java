module com.isador.jspe {
    requires com.isador.jspe.core;
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires jakarta.el;

    opens com.isador.jspe.ui;
    exports com.isador.jspe.ui;
}
