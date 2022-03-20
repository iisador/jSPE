package com.isador.jspe.ui;

import com.isador.jspe.core.Payload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

@ApplicationScoped
public class PayloadsController {

    private TableView<Payload> payloads;
    private Button btnRemovePayload;

    @SuppressWarnings("unchecked")
    private void onSceneCreated(@Observes Scene scene) {
        payloads = (TableView<Payload>) scene.lookup("#payloads");
        btnRemovePayload = (Button) scene.lookup("#btnRemovePayload");
    }

    public void addPayload(MouseEvent event) {
    }

    public void removePayload(MouseEvent event) {
    }
}
