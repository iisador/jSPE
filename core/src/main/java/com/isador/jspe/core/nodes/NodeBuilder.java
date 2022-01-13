package com.isador.jspe.core.nodes;


import java.util.Map;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.SpeModel;

/**
 * @since 2.0.0
 */
public interface NodeBuilder<T extends Node> {

    T build();

    void addCase(T child, double probability);

    void removeCase(T child);

    void setModel(SpeModel<T> model);

    void removeModel();

    void addStep(T child);

    void removeStep(T child);

    void setRepeatCount(int count);

    void removeRepeatCount();

    void setId(String id);

    void setTitle(String title);

    void setPayload(Map<Payload, Double> payload);

    Map<Payload, Double> addPayload(Payload payload, double value);

    void removePayload(Payload payload);
}
