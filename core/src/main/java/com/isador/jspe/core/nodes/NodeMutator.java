package com.isador.jspe.core.nodes;

import java.util.Map;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.SpeModel;

public interface NodeMutator<T extends Node> {

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

    void addPayload(Map<Payload, Double> payload);

    void addPayload(Payload payload, double value);

    void removePayload(Payload payload);
}
