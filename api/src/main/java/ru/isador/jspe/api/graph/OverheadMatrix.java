package ru.isador.jspe.api.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.isador.jspe.api.facility.SoftwareResource;

public class OverheadMatrix {

    private final Map<Tuple, Float> overhead;

    public OverheadMatrix() {
        overhead = new HashMap<>();
    }

    public void addOverhead(SoftwareResource softwareResource, HardwareResource hardwareResource, float amount) {
        overhead.put(new Tuple(softwareResource, hardwareResource), amount);
    }

    public float getSoftwareResourceTime(SoftwareResource softwareResource) {
        return overhead.entrySet().stream().filter(e -> e.getKey().softwareResource.equals(softwareResource)).map(e -> e.getKey().hardwareResource.getServiceTime() * e.getValue())
                .reduce(0.0f, Float::sum);
    }

    public Collection<HardwareResource> getHardwareResources() {
        return overhead.keySet().stream()
                .map(t -> t.hardwareResource)
                .collect(Collectors.toSet());
    }

    public Collection<SoftwareResource> getSoftwareResources() {
        return overhead.keySet().stream()
                .map(t -> t.softwareResource)
                .collect(Collectors.toSet());
    }

    public float getAmount(SoftwareResource softwareResource, HardwareResource hardwareResource) {
        return overhead.getOrDefault(new Tuple(softwareResource, hardwareResource), 0.0f);
    }

    private record Tuple(SoftwareResource softwareResource, HardwareResource hardwareResource) {

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Tuple tuple = (Tuple) o;
            return softwareResource.equals(tuple.softwareResource) && hardwareResource.equals(tuple.hardwareResource);
        }

        @Override
        public int hashCode() {
            return Objects.hash(softwareResource, hardwareResource);
        }

        @Override
        public String toString() {
            return softwareResource + ", " + hardwareResource;
        }
    }
}
