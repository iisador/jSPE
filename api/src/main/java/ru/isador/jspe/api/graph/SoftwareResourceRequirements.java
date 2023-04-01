package ru.isador.jspe.api.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import ru.isador.jspe.api.facility.SoftwareResource;

public final class SoftwareResourceRequirements {

    private final Map<SoftwareResource, Float> resourceRequirements;

    public SoftwareResourceRequirements() {
        resourceRequirements = new HashMap<>();
    }

    public SoftwareResourceRequirements(Map<SoftwareResource, Float> resourceRequirements) {
        this.resourceRequirements = new HashMap<>(resourceRequirements);
    }

    public SoftwareResourceRequirements clone() {
        return new SoftwareResourceRequirements(resourceRequirements);
    }

    public void addRequirement(SoftwareResource softwareResource, Float requirement) {
        resourceRequirements.put(softwareResource, requirement);
    }

    public SoftwareResourceRequirements plus(SoftwareResourceRequirements otherResourceRequirements) {
        return new SoftwareResourceRequirements(resourceRequirements.keySet()
                .stream()
                .map(r -> new SimpleEntry<>(r, resourceRequirements.get(r) + otherResourceRequirements.resourceRequirements.get(r)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public SoftwareResourceRequirements multiply(int factor) {
        return new SoftwareResourceRequirements(resourceRequirements.keySet()
                .stream()
                .map(r -> new SimpleEntry<>(r, resourceRequirements.get(r) * factor))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public float getTime(OverheadMatrix overheadMatrix) {
        return resourceRequirements.entrySet()
                .stream()
                .map(e -> overheadMatrix.getSoftwareResourceTime(e.getKey()) * e.getValue())
                .reduce(0.0f, Float::sum);
    }

    public Map<SoftwareResource, Float> getResourceRequirements() {
        return resourceRequirements;
    }

    @Override
    public String toString() {
        return resourceRequirements.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining("; "));
    }
}
