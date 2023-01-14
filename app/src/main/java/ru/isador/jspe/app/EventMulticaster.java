package ru.isador.jspe.app;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import ru.isador.jspe.app.core.ApplicationEvent;

@ApplicationScoped
public class EventMulticaster {

    private final Event<ApplicationEvent> event;

    @Inject
    public EventMulticaster(Event<ApplicationEvent> event) {
        this.event = event;
    }

    public void fire(ApplicationEvent event) {
        this.event.fire(event);
    }

    public void fireAsync(ApplicationEvent event) {
        this.event.fireAsync(event);
    }
}
