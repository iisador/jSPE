package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.graph.OverheadMatrix;

/**
 * Узел с параллельным выполнением.
 * Ждет завершения всех узлов.
 *
 * @since 1.0.0
 */
public class PardoNode extends CompoundNode {

    @Override
    public float getMinTime(OverheadMatrix overheadMatrix) {
        return 0;
    }

    @Override
    public float getMaxTime(OverheadMatrix overheadMatrix) {
        return 0;
    }

    @Override
    public float getAvgTime(OverheadMatrix overheadMatrix) {
        return 0;
    }

    @Override
    public Node getMinPath(Node parent, OverheadMatrix overheadMatrix) {
        return null;
    }

    @Override
    public Node getMaxPath(Node parent, OverheadMatrix overheadMatrix) {
        return null;
    }

    @Override
    public Node cloneNode() {
        return null;
    }
}
