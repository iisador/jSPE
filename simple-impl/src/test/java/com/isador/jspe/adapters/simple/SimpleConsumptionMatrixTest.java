package com.isador.jspe.adapters.simple;

import java.util.Collection;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleConsumptionMatrixTest {

    @Test
    void testGetConsumption() {
        SimpleConsumptionMatrix matrix = new SimpleConsumptionMatrix();

        Exception e = assertThrows(NullPointerException.class, () -> matrix.getConsumption(null, null));
        assertEquals("payload should be not null", e.getMessage());

        e = assertThrows(NullPointerException.class, () -> matrix.getConsumption(new Payload("message"), null));
        assertEquals("resource should be not null", e.getMessage());

        Double actual = matrix.getConsumption(new Payload("message"), new Resource("cpu"));
        assertEquals(0.0, actual, "Invalid return value");
    }

    @Test
    void testSetConsumption() {
        SimpleConsumptionMatrix matrix = new SimpleConsumptionMatrix();
        Payload payload = new Payload("message");
        Resource resource = new Resource("cpu");

        Exception e = assertThrows(NullPointerException.class, () -> matrix.setConsumption(null, null, null));
        assertEquals("payload should be not null", e.getMessage());

        e = assertThrows(NullPointerException.class, () -> matrix.setConsumption(payload, null, null));
        assertEquals("resource should be not null", e.getMessage());

        e = assertThrows(NullPointerException.class, () -> matrix.setConsumption(payload, resource, null));
        assertEquals("value should be not null", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> matrix.setConsumption(payload, resource, -1.0));
        assertEquals("value should be > 0.0", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> matrix.setConsumption(payload, resource, 0.0));
        assertEquals("value should be > 0.0", e.getMessage());

        Double actualConsumption = matrix.getConsumption(payload, resource);
        assertEquals(0.0, actualConsumption, "Invalid matrix state");

        matrix.setConsumption(payload, resource, 2.0);
        actualConsumption = matrix.getConsumption(payload, resource);
        assertEquals(2.0, actualConsumption, "Invalid matrix state");
    }

    @Test
    void testRemoveConsumption() {
        SimpleConsumptionMatrix matrix = new SimpleConsumptionMatrix();
        Payload payload = new Payload("message");
        Resource resource = new Resource("cpu");
        matrix.setConsumption(payload, resource, 2.0);

        assertDoesNotThrow(() -> matrix.remove(null, null));

        matrix.remove(payload, resource);
        Double actualConsumption = matrix.getConsumption(payload, resource);
        assertEquals(0.0, actualConsumption, "Invalid matrix state");
    }

    @Test
    void testGetMappedResources() {
        SimpleConsumptionMatrix matrix = new SimpleConsumptionMatrix();
        Payload payload = new Payload("message");
        Resource resource1 = new Resource("mem");
        Resource resource2 = new Resource("cpu");

        Assertions.assertDoesNotThrow(() -> matrix.getMappedResources(null));

        Collection<Resource> actualMappedResources = matrix.getMappedResources(null);
        assertNotNull(actualMappedResources, "Invalid mapped resources collection");
        assertTrue(actualMappedResources.isEmpty(), "Invalid mapped resources state");

        actualMappedResources = matrix.getMappedResources(payload);
        assertNotNull(actualMappedResources, "Invalid mapped resources collection");
        assertTrue(actualMappedResources.isEmpty(), "Invalid mapped resources state");

        matrix.setConsumption(payload, resource1, 1.0);
        assertEquals(1, matrix.getMappedResources(payload).size(), "Invalid mapped resources size");

        matrix.setConsumption(payload, resource2, 2.0);
        actualMappedResources = matrix.getMappedResources(payload);
        assertEquals(2, actualMappedResources.size(), "Invalid mapped resources size");

        matrix.setConsumption(payload, resource2, 4.0);
        actualMappedResources = matrix.getMappedResources(payload);
        assertEquals(2, actualMappedResources.size(), "Invalid mapped resources size");
    }

    @Test
    void testToString() {
        assertNotNull(new SimpleConsumptionMatrix().toString());
    }
}
