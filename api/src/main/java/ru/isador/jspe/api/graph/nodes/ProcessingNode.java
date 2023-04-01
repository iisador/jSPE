package ru.isador.jspe.api.graph.nodes;

/**
 * Узел, совершающий работу.
 *
 * @since 1.0.0
 */
public abstract class ProcessingNode extends AbstractNode {

    public ProcessingNode() {
        super();
    }

    public ProcessingNode(String name) {
        super(name);
    }
}
