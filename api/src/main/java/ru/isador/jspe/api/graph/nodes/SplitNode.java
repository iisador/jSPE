package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.graph.OverheadMatrix;

/**
 * Узел с параллельным выполнением.
 * Не ждет завершения всех узлов.
 *
 * @since 1.0.0
 */
public class SplitNode extends CompoundNode {

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
