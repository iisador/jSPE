package ru.isador.jspe.ui.payloads;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ru.isador.jspe.api.Payload;

@ApplicationScoped
public class PayloadsController {

    private TableView<Payload> payloads;
    private Button btnRemovePayload;

    @SuppressWarnings("unchecked")
    private void onSceneCreated(@Observes Scene scene) {
        payloads = (TableView<Payload>) scene.lookup("#payloads");
        btnRemovePayload = (Button) scene.lookup("#btnRemovePayload");
    }

    public void addPayload() {
    }

    public void removePayload() {
    }
}
