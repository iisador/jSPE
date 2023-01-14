
package ru.isador.jspe.api.nodes;

import java.util.ArrayList;
import java.util.Collection;

import ru.isador.jspe.api.SoftwareResourceRequirement;

/**
 * Узел модели.
 *
 * @since 1.0.0
 */
public class Node {

    protected String id;
    protected String name;
    protected final Collection<SoftwareResourceRequirement> softwareResourceRequirements;

    public Node() {
        softwareResourceRequirements = new ArrayList<>();
    }

    public Node(String id, String name) {
        this.id = id;
        this.name = name;
        softwareResourceRequirements = new ArrayList<>();
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

    public Collection<SoftwareResourceRequirement> getSoftwareResourceRequirements() {
        return softwareResourceRequirements;
    }
}
