package com.isador.jspe.core.nodes;


import java.util.Map;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.SpeModel;

/**
 * @since 2.0.0
 */
public interface NodeBuilder {

    Node build();

    void addCase(Node child, double probability);

    void removeCase(Node child);

    void setModel(SpeModel model);

    void removeModel();

    void addStep(Node child);

    void removeStep(Node child);

    void setRepeatCount(int count);

    void removeRepeatCount();

    void setId(String id);

    void setTitle(String title);

    void setPayload(Map<Payload, Double> payload);

    Map<Payload, Double> addPayload(Payload payload, double value);

    void removePayload(Payload payload);
}
