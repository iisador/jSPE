package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.graph.OverheadMatrix;

/**
 * Узел с циклом.
 *
 * @since 1.0.0
 */
public class RepetitionNode extends CompoundNode {

    private int repetitionFactor;

    private Node repetitionNode;

    public Node getRepetitionNode() {
        return repetitionNode;
    }

    public void setRepetitionNode(Node repetitionNode) {
        this.repetitionNode = repetitionNode;
    }

    public int getRepetitionFactor() {
        return repetitionFactor;
    }

    public void setRepetitionFactor(int repetitionFactor) {
        this.repetitionFactor = repetitionFactor;
    }

    @Override
    public float getMinTime(OverheadMatrix overheadMatrix) {
        float time = (softwareResourceRequirements.getTime(overheadMatrix) + repetitionNode.getMinTime(overheadMatrix)) * repetitionFactor;
        return child == null ? time : time + child.getMinTime(overheadMatrix);
    }

    @Override
    public float getMaxTime(OverheadMatrix overheadMatrix) {
        float time = (softwareResourceRequirements.getTime(overheadMatrix) + repetitionNode.getMinTime(overheadMatrix)) * repetitionFactor;
        return child == null ? time : time + child.getMaxTime(overheadMatrix);
    }

    @Override
    public float getAvgTime(OverheadMatrix overheadMatrix) {
        float time = (softwareResourceRequirements.getTime(overheadMatrix) + repetitionNode.getMinTime(overheadMatrix)) * repetitionFactor;
        return child == null ? time : time + child.getAvgTime(overheadMatrix);
    }

    @Override
    public Node getMinPath(Node parent, OverheadMatrix overheadMatrix) {
        RepetitionNode clone = this.cloneNode();
        parent.setChild(clone);
        clone.setParent(parent);
        if (child != null) {
            clone.setChild(child.getMinPath(clone, overheadMatrix));
        }
        return clone;
    }

    @Override
    public Node getMaxPath(Node parent, OverheadMatrix overheadMatrix) {
        RepetitionNode clone = this.cloneNode();
        parent.setChild(clone);
        clone.setParent(parent);
        if (child != null) {
            clone.setChild(child.getMaxPath(clone, overheadMatrix));
        }
        return clone;
    }

    @Override
    public RepetitionNode cloneNode() {
        RepetitionNode clone = new RepetitionNode();
        clone.fillCommonInfo(this);
        clone.repetitionFactor = this.repetitionFactor;
        clone.repetitionNode = repetitionNode.cloneNode();
        return clone;
    }
}
