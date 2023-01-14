package ru.isador.jspe.api;

import java.util.ArrayList;
import java.util.Collection;

public class OverheadMatrix {

    private final Collection<OverheadMatrixElement> elements;

    public OverheadMatrix() {
        elements = new ArrayList<>();
    }

    public Collection<OverheadMatrixElement> getElements() {
        return elements;
    }
}
