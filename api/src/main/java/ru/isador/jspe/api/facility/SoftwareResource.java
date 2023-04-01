package ru.isador.jspe.api.facility;

import java.util.Objects;
import java.util.UUID;

public class SoftwareResource {

    private final String id;
    private String name;

    public SoftwareResource() {
        id = UUID.randomUUID().toString();
    }

    public SoftwareResource(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SoftwareResource that = (SoftwareResource) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
