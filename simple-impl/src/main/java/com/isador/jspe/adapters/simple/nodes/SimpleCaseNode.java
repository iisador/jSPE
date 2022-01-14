package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

import com.isador.jspe.core.nodes.CaseNode;

public final class SimpleCaseNode extends AbstractCompoundNode implements CaseNode {

    @Serial
    private static final long serialVersionUID = -1522668239964301791L;

    private final Map<String, Double> probabilities;

    public SimpleCaseNode(String id, String title) {
        super(id, title);
        this.probabilities = new HashMap<>();
    }

    public SimpleCaseNode(String title) {
        super(title);
        this.probabilities = new HashMap<>();
    }

    public SimpleCaseNode() {
        super();
        this.probabilities = new HashMap<>();
    }

    public void setProbability(String id, double probability) {
        probabilities.put(id, probability);
    }

    public void removeProbability(String id) {
        probabilities.remove(id);
    }
}
