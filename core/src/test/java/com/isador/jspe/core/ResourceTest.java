//package com.isador.jspe.core;
//
//import nl.jqno.equalsverifier.EqualsVerifier;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class ResourceTest {
//
//    @Test
//    void testConstructorIdTitle() {
//        Exception e = assertThrows(NullPointerException.class, () -> new Resource(null, null));
//        assertEquals("id should be not null", e.getMessage());
//
//        e = assertThrows(IllegalArgumentException.class, () -> new Resource("", null));
//        assertEquals("id should be not blank", e.getMessage());
//
//        e = assertThrows(IllegalArgumentException.class, () -> new Resource("123", ""));
//        assertEquals("title should be not blank", e.getMessage());
//
//        Resource resource = new Resource("123", "123");
//
//        assertEquals("123", resource.getId(), "Invalid resource id");
//        assertEquals("123", resource.getTitle(), "Invalid resource title");
//        assertNull(resource.getServiceUnit(), "Invalid resource serviceUnit");
//        assertNull(resource.getServiceTime(), "Invalid resource serviceTime");
//    }
//
//    @Test
//    void testConstructorTitle() {
//        Exception e = assertThrows(IllegalArgumentException.class, () -> new Resource(""));
//        assertEquals("title should be not blank", e.getMessage());
//
//        Resource resource = new Resource("123");
//
//        assertNotNull(resource.getId(), "Invalid resource id");
//        assertEquals("123", resource.getTitle(), "Invalid resource title");
//        assertNull(resource.getServiceUnit(), "Invalid resource serviceUnit");
//        assertNull(resource.getServiceTime(), "Invalid resource serviceTime");
//    }
//
//    @Test
//    void testSetId() {
//        Resource resource = new Resource("123", "123");
//
//        Exception e = assertThrows(NullPointerException.class, () -> resource.setId(null));
//        assertEquals("id should be not null", e.getMessage());
//
//        e = assertThrows(IllegalArgumentException.class, () -> resource.setId(""));
//        assertEquals("id should be not blank", e.getMessage());
//
//        resource.setId("id");
//        assertEquals("id", resource.getId(), "Invalid resource id");
//    }
//
//    @Test
//    void testSetTitle() {
//        Resource resource = new Resource("123", "123");
//
//        Exception e = assertThrows(IllegalArgumentException.class, () -> resource.setTitle(""));
//        assertEquals("title should be not blank", e.getMessage());
//
//        resource.setTitle("title");
//        assertEquals("title", resource.getTitle(), "Invalid resource title");
//
//        resource.setTitle(null);
//        assertNull(resource.getTitle(), "Invalid resource title");
//    }
//
//    @Test
//    void testSetServiceTime() {
//        Resource resource = new Resource("123", "123");
//
//        Exception e = assertThrows(IllegalArgumentException.class, () -> resource.setServiceTime(-1.0));
//        assertEquals("Service time should be >= 0", e.getMessage());
//
//        resource.setServiceTime(null);
//        assertNull(resource.getServiceTime(), "Invalid resource service time");
//
//        resource.setServiceTime(10.000);
//        assertEquals(10.000, resource.getServiceTime(), "Invalid resource service time");
//    }
//
//    @Test
//    void testSetServiceUnit() {
//        Resource resource = new Resource("123", "123");
//
//        resource.setServiceUnit("unit");
//        assertEquals("unit", resource.getServiceUnit(), "Invalids resource serviceUnit");
//
//        resource.setServiceUnit(null);
//        assertNull(resource.getServiceUnit(), "Invalids resource serviceUnit");
//    }
//
//    @Test
//    void testEqualsHashCode() {
//        EqualsVerifier.simple().forClass(Resource.class)
//                .withNonnullFields("id")
//                .withOnlyTheseFields("id")
//                .verify();
//    }
//
//    @Test
//    void testToString() {
//        assertNotNull(new Resource("123", "123").toString(), "toString method should not return null");
//    }
//}
