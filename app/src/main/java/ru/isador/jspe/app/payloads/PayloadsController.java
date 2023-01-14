package ru.isador.jspe.app.payloads;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import ru.isador.jspe.app.core.SceneCreatedEvent;

/**
 * Контроллер области с полезной нагрузкой.
 */
@ApplicationScoped
public class PayloadsController {

    @SuppressWarnings("unchecked")
    private void onSceneCreated(@Observes SceneCreatedEvent event) {
        //        TableView<Payload> payloads = (TableView<Payload>) event.scene().lookup("#payloads");
        //        Button btnRemovePayload = (Button) event.scene().lookup("#btnRemovePayload");
    }

    public void addPayload() {
    }

    public void removePayload() {
    }
}
