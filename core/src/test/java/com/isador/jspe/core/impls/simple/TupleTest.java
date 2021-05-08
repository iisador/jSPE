package com.isador.jspe.core.impls.simple;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TupleTest {

    @Test
    void testConstructor() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> new Tuple<>(null, null, null));
        assertEquals("X parameter should be not null", e.getMessage(), "Invalid exception message");

        e = assertThrows(NullPointerException.class, () -> new Tuple<>(1, null, null));
        assertEquals("Y parameter should be not null", e.getMessage(), "Invalid exception message");

        e = assertThrows(NullPointerException.class, () -> new Tuple<>(1, 1, null));
        assertEquals("Value should be not null", e.getMessage(), "Invalid exception message");

        Tuple<Integer, Integer, Integer> tuple = new Tuple<>(1, 1, 1);

        assertEquals(1, tuple.getX(), "X parameter is not valid");
        assertEquals(1, tuple.getY(), "Y parameter is not valid");
        assertEquals(1, tuple.getV(), "Value parameter is not valid");
    }

    @Test
    void testSetValue() {
        Tuple<Integer, Integer, Integer> tuple = new Tuple<>(1, 1, 1);

        tuple.setV(3);

        assertEquals(3, tuple.getV(), "Value parameter is not valid");
    }

    @Test
    void testEqualsHashCode() {
        EqualsVerifier.simple().forClass(Tuple.class)
                .withNonnullFields("x", "y")
                .withOnlyTheseFields("x", "y")
                .verify();
    }

    @Test
    void testToString() {
        assertNotNull(new Tuple<>(1, 1, 1).toString(), "toString method should not return null");
    }
}
