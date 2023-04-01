package ru.isador.jspe.api.graph.nodes;

import java.util.Objects;
import java.util.UUID;

import ru.isador.jspe.api.graph.OverheadMatrix;
import ru.isador.jspe.api.graph.SoftwareResourceRequirements;

/**
 * Узел модели.
 *
 * @since 1.0.0
 */
public abstract class AbstractNode implements Node {

    protected SoftwareResourceRequirements softwareResourceRequirements;
    protected String id;
    protected String name;
    protected Node child;
    protected Node parent;

    public AbstractNode() {
        id = UUID.randomUUID().toString();
        softwareResourceRequirements = new SoftwareResourceRequirements();
    }

    public AbstractNode(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
        softwareResourceRequirements = new SoftwareResourceRequirements();
    }

    protected void fillCommonInfo(AbstractNode source) {
        this.name = source.name;
        this.softwareResourceRequirements = source.softwareResourceRequirements.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SoftwareResourceRequirements getSoftwareResourceRequirements() {
        return softwareResourceRequirements;
    }

    @Override
    public Node getChild() {
        return child;
    }

    @Override
    public void setChild(Node child) {
        this.child = child;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractNode that = (AbstractNode) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString(OverheadMatrix overheadMatrix) {
        return String.format("%s (%.1f)", name, softwareResourceRequirements.getTime(overheadMatrix));
    }
}
