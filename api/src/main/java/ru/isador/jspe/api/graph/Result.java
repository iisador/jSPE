package ru.isador.jspe.api.graph;

import ru.isador.jspe.api.graph.nodes.Node;

public class Result {

    private Node minPathNode;
    private float minTime;
    private Node maxPathNode;
    private float maxTime;
    private Node avgPathNode;
    private float avgTime;
    private SoftwareResourceRequirements totalSoftwareResourceRequirements;
    private OverheadMatrix overheadMatrix;

    public Node getMinPathNode() {
        return minPathNode;
    }

    public void setMinPathNode(Node minPathNode) {
        this.minPathNode = minPathNode;
    }

    public float getMinTime() {
        return minTime;
    }

    public void setMinTime(float minTime) {
        this.minTime = minTime;
    }

    public Node getMaxPathNode() {
        return maxPathNode;
    }

    public void setMaxPathNode(Node maxPathNode) {
        this.maxPathNode = maxPathNode;
    }

    public float getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(float maxTime) {
        this.maxTime = maxTime;
    }

    public Node getAvgPathNode() {
        return avgPathNode;
    }

    public void setAvgPathNode(Node avgPathNode) {
        this.avgPathNode = avgPathNode;
    }

    public float getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(float avgTime) {
        this.avgTime = avgTime;
    }

    public SoftwareResourceRequirements getTotalSoftwareResourceRequirements() {
        return totalSoftwareResourceRequirements;
    }

    public void setTotalSoftwareResourceRequirements(SoftwareResourceRequirements totalSoftwareResourceRequirements) {
        this.totalSoftwareResourceRequirements = totalSoftwareResourceRequirements;
    }
}
