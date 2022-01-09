package com.isador.jspe.core;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PayloadTest {

    @Test
    void testConstructorIdTitle() {
        Exception e = assertThrows(NullPointerException.class, () -> new Payload(null, null));
        assertEquals("id should be not null", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> new Payload("", null));
        assertEquals("id should be not blank", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> new Payload("123", ""));
        assertEquals("title should be not blank", e.getMessage());

        Payload payload = new Payload("123", "123");

        assertEquals("123", payload.getId(), "Invalid payload id");
        assertEquals("123", payload.getTitle(), "Invalid payload title");
    }

    @Test
    void testConstructorTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Payload(""));
        assertEquals("title should be not blank", e.getMessage());

        Payload payload = new Payload("123");

        assertNotNull(payload.getId(), "Invalid payload id");
        assertEquals("123", payload.getTitle(), "Invalid payload title");
    }

    @Test
    void testSetId() {
        Payload payload = new Payload("123", "123");

        Exception e = assertThrows(NullPointerException.class, () -> payload.setId(null));
        assertEquals("id should be not null", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> payload.setId(""));
        assertEquals("id should be not blank", e.getMessage());

        payload.setId("id");
        assertEquals("id", payload.getId(), "Invalid payload id");
    }

    @Test
    void testSetTitle() {
        Payload payload = new Payload("123", "123");

        Exception e = assertThrows(IllegalArgumentException.class, () -> payload.setTitle(""));
        assertEquals("title should be not blank", e.getMessage());

        payload.setTitle("title");
        assertEquals("title", payload.getTitle(), "Invalid payload title");

        payload.setTitle(null);
        assertNull(payload.getTitle(), "Invalid payload title");
    }

    @Test
    void testEqualsHashCode() {
        EqualsVerifier.simple().forClass(Payload.class)
                .withNonnullFields("id")
                .withOnlyTheseFields("id")
                .verify();
    }

    @Test
    void testToString() {
        assertNotNull(new Payload("test").toString(), "toString method should not return null");
    }
}
