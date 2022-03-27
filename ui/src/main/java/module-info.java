module ru.isador.jspe {
    requires ru.isador.jspe.core;
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires jakarta.el;

    requires org.slf4j;

    opens ru.isador.jspe.ui;
    exports ru.isador.jspe.ui;
    exports ru.isador.jspe.ui.resources;
    opens ru.isador.jspe.ui.resources;
    exports ru.isador.jspe.ui.payloads;
    opens ru.isador.jspe.ui.payloads;
    exports ru.isador.jspe.ui.menu;
    opens ru.isador.jspe.ui.menu;
    exports ru.isador.jspe.ui.core;
    opens ru.isador.jspe.ui.core;
}
