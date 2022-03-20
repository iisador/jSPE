module com.isador.jspe {
    requires com.isador.jspe.core;
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires jakarta.el;

    requires org.slf4j;

    opens com.isador.jspe.ui;
    exports com.isador.jspe.ui;
    exports com.isador.jspe.ui.resources;
    opens com.isador.jspe.ui.resources;
    exports com.isador.jspe.ui.payloads;
    opens com.isador.jspe.ui.payloads;
    exports com.isador.jspe.ui.menu;
    opens com.isador.jspe.ui.menu;
    exports com.isador.jspe.ui.core;
    opens com.isador.jspe.ui.core;
}
