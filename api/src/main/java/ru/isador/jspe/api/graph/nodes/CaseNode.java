package ru.isador.jspe.api.graph.nodes;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ru.isador.jspe.api.graph.OverheadMatrix;

/**
 * Узел выбора.
 *
 * @since 1.0.0
 */
public class CaseNode extends CompoundNode {

    private final Map<Node, Float> caseNodes;

    public CaseNode() {
        caseNodes = new HashMap<>();
    }

    public void addCaseNode(Node node, Float probability) {
        caseNodes.put(node, probability);
    }

    public Map<Node, Float> getCaseNodes() {
        return caseNodes;
    }

    public Node getFirstCase() {
        return caseNodes.keySet().stream().findFirst().orElseThrow();
    }

    @Override
    public CaseNode cloneNode() {
        CaseNode node = new CaseNode();
        node.fillCommonInfo(this);
        return node;
    }

    @Override
    public float getMinTime(OverheadMatrix overheadMatrix) {
        float time = caseNodes.keySet().stream().map(aFloat -> softwareResourceRequirements.getTime(overheadMatrix) + aFloat.getMinTime(overheadMatrix))
                .min(Float::compareTo).orElse(Float.MAX_VALUE);
        return child == null ? time : time + child.getMinTime(overheadMatrix);
    }

    @Override
    public float getMaxTime(OverheadMatrix overheadMatrix) {
        float time = caseNodes.keySet().stream().map(aFloat -> softwareResourceRequirements.getTime(overheadMatrix) + aFloat.getMaxTime(overheadMatrix))
                .max(Float::compareTo).orElse(Float.MAX_VALUE);
        return child == null ? time : time + child.getMaxTime(overheadMatrix);
    }

    @Override
    public float getAvgTime(OverheadMatrix overheadMatrix) {
        float time = caseNodes.entrySet().stream().map(e -> (softwareResourceRequirements.getTime(overheadMatrix) + e.getKey().getMaxTime(overheadMatrix)) * e.getValue())
                .reduce(0.0f, Float::sum);
        return child == null ? time : time + child.getAvgTime(overheadMatrix);
    }

    @Override
    public Node getMinPath(Node parent, OverheadMatrix overheadMatrix) {
        CaseNode clone = this.cloneNode();
        if (child != null) {
            clone.setChild(child.getMinPath(clone, overheadMatrix));
        }
        parent.setChild(clone);
        clone.setParent(parent);
        Entry<Node, Float> minCaseEntry = caseNodes.keySet().stream()
                .map(aFloat -> new SimpleEntry<>(aFloat, softwareResourceRequirements.getTime(overheadMatrix) + aFloat.getMinTime(overheadMatrix)))
                .min((o1, o2) -> Float.compare(o1.getValue(), o2.getValue())).orElseThrow();
        Node childClone = minCaseEntry.getKey().cloneNode();
        if(minCaseEntry.getKey().getChild() != null) {
            childClone.setChild(minCaseEntry.getKey().getChild().getMinPath(childClone, overheadMatrix));
        }
        clone.caseNodes.put(childClone, minCaseEntry.getValue());
        return clone;
    }

    @Override
    public Node getMaxPath(Node parent, OverheadMatrix overheadMatrix) {
        CaseNode clone = this.cloneNode();
        if (child != null) {
            clone.setChild(child.getMinPath(clone, overheadMatrix));
        }
        parent.setChild(clone);
        clone.setParent(parent);
        Entry<Node, Float> minCaseEntry = caseNodes.keySet().stream()
                .map(aFloat -> new SimpleEntry<>(aFloat, softwareResourceRequirements.getTime(overheadMatrix) + aFloat.getMaxTime(overheadMatrix)))
                .max((o1, o2) -> Float.compare(o1.getValue(), o2.getValue())).orElseThrow();
        Node childClone = minCaseEntry.getKey().cloneNode();
        if(minCaseEntry.getKey().getChild() != null) {
            childClone.setChild(minCaseEntry.getKey().getChild().getMaxPath(childClone, overheadMatrix));
        }
        clone.caseNodes.put(childClone, minCaseEntry.getValue());
        return clone;
    }
}
