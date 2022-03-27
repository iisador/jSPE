package ru.isador.jspe.core.nodes;


import java.util.Map;

import ru.isador.jspe.core.Payload;
import ru.isador.jspe.core.SpeModel;

/**
 * @since 2.0.0
 */
public interface NodeBuilder<T extends Node> {

    T build();

    NodeBuilder<T> addCase(T step, double probability);

    NodeBuilder<T> removeCase(T step);

    NodeBuilder<T> setModel(SpeModel<T> model);

    NodeBuilder<T> removeModel();

    NodeBuilder<T> addStep(T step);

    NodeBuilder<T> removeStep(T step);

    NodeBuilder<T> setRepeatCount(int count);

    NodeBuilder<T> removeRepeatCount();

    NodeBuilder<T> setId(String id);

    NodeBuilder<T> setTitle(String title);

    NodeBuilder<T> addPayload(Payload payload, double value);

    NodeBuilder<T> removePayload(Payload payload);
}
