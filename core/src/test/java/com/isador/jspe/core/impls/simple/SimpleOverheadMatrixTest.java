package com.isador.jspe.core.impls.simple;

import com.isador.jspe.core.Resource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class SimpleOverheadMatrixTest {

    @Test
    void testGetResourceMatrix() {
        SimpleOverheadMatrix matrix = new SimpleOverheadMatrix();

        assertNull(matrix.getResourceMatrix(), "Invalid overhead matrix state");

        matrix.setResourceMatrix(new SimpleMatrix<>());
        assertNotNull(matrix.getResourceMatrix(), "Invalid overhead matrix state");
    }

    @Test
    void testGetPayloadMatrix() {
        SimpleOverheadMatrix matrix = new SimpleOverheadMatrix();

        assertNull(matrix.getPayloadMatrix(), "Invalid overhead matrix state");

        matrix.setPayloadMatrix(new SimpleMatrix<>());
        assertNotNull(matrix.getPayloadMatrix(), "Invalid overhead matrix state");
    }

    @Test
    void testGetServiceTime() {
        SimpleOverheadMatrix matrix = new SimpleOverheadMatrix();
        matrix.setPayloadMatrix(new SimpleMatrix<>());
        matrix.setResourceMatrix(new SimpleMatrix<>());

        Resource resource1 = new Resource();
        resource1.setServiceTime(5000L);
        matrix.getResourceMatrix().put(resource1, 5.0);

        Resource resource2 = new Resource();
        resource2.setServiceTime(1000L);
        matrix.getResourceMatrix().put(resource2, 2.0);

        Long actualServiceTime = matrix.getServiceTime();

        assertNotNull(actualServiceTime, "Invalid service time");
        assertEquals(1500L, actualServiceTime, "Invalid service time state");
    }
}
