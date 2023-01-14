module ru.isador.jspe.app {
    uses ru.isador.jspe.api.spi.ProjectFactory;
    requires ru.isador.jspe.api;

    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.inject;
    requires jakarta.cdi;
    requires jakarta.el;

    requires org.slf4j;

    opens ru.isador.jspe.app;
    exports ru.isador.jspe.app;
    exports ru.isador.jspe.app.resources;
    opens ru.isador.jspe.app.resources;
    exports ru.isador.jspe.app.payloads;
    opens ru.isador.jspe.app.payloads;
    exports ru.isador.jspe.app.menu;
    opens ru.isador.jspe.app.menu;
    exports ru.isador.jspe.app.core;
    opens ru.isador.jspe.app.core;
}
