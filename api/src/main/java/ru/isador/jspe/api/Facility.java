package ru.isador.jspe.api;

import java.util.ArrayList;
import java.util.Collection;

public class Facility {

    private String id;
    private String name;
    private final Collection<Server> servers;
    private OverheadMatrix overheadMatrix;

    public Facility() {
        servers = new ArrayList<>();
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

    public Collection<Server> getServers() {
        return servers;
    }

    public OverheadMatrix getOverheadMatrix() {
        return overheadMatrix;
    }

    public void setOverheadMatrix(OverheadMatrix overheadMatrix) {
        this.overheadMatrix = overheadMatrix;
    }
}
