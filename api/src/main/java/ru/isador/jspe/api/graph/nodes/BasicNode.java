package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.graph.OverheadMatrix;

/**
 * Простой узел.
 *
 * @since 1.0.0
 */
public class BasicNode extends ProcessingNode {

    public BasicNode() {
        super();
    }

    public BasicNode(String name) {
        super(name);
    }

    @Override
    public BasicNode cloneNode() {
        BasicNode node = new BasicNode();
        node.fillCommonInfo(this);
        return node;
    }

    @Override
    public float getMinTime(OverheadMatrix overheadMatrix) {
        float time = softwareResourceRequirements.getTime(overheadMatrix);
        return child == null ? time : time + child.getMinTime(overheadMatrix);
    }

    @Override
    public float getMaxTime(OverheadMatrix overheadMatrix) {
        float time = softwareResourceRequirements.getTime(overheadMatrix);
        return child == null ? time : time + child.getMaxTime(overheadMatrix);
    }

    @Override
    public float getAvgTime(OverheadMatrix overheadMatrix) {
        float time = softwareResourceRequirements.getTime(overheadMatrix);
        return child == null ? time : time + child.getAvgTime(overheadMatrix);
    }

    @Override
    public Node getMinPath(Node parent, OverheadMatrix overheadMatrix) {
        BasicNode clone = this.cloneNode();
        if (child != null) {
            clone.setChild(child.getMinPath(clone, overheadMatrix));
        }
        parent.setChild(clone);
        clone.setParent(parent);
        return clone;
    }

    @Override
    public Node getMaxPath(Node parent, OverheadMatrix overheadMatrix) {
        BasicNode clone = this.cloneNode();
        if (child != null) {
            clone.setChild(child.getMaxPath(clone, overheadMatrix));
        }
        parent.setChild(clone);
        clone.setParent(parent);
        return clone;
    }
}
