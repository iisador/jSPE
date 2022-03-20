package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

public final class CaseNode extends AbstractCompoundNode {

    @Serial
    private static final long serialVersionUID = -1522668239964301791L;

    private final Map<String, Double> probabilities;

    public CaseNode(String id, String title) {
        super(id, title);
        this.probabilities = new HashMap<>();
    }

    public CaseNode(String title) {
        super(title);
        this.probabilities = new HashMap<>();
    }

    public CaseNode() {
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
