package ru.isador.jspe.api.nodes;

/**
 * Узел, совершающий работу.
 *
 * @since 1.0.0
 */
public class ProcessingNode extends Node {

    private Float probability;

    public ProcessingNode() {
        super();
    }

    public ProcessingNode(String id, String name) {
        super(id, name);
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float value) {
        this.probability = value;
    }
}
