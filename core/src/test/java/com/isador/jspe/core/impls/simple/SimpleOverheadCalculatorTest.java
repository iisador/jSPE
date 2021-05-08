package com.isador.jspe.core.impls.simple;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.OverheadMatrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;
import com.isador.jspe.core.impls.simple.nodes.AbstractNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimpleOverheadCalculatorTest {

    ConsumptionMatrix consumptionMatrix;

    private Resource cpu;
    private Resource network;
    private Resource hdd;

    private Payload workUnit;
    private Payload io;
    private Payload message;

    @BeforeEach
    void setUp() {
        cpu = newResource("cpu", "cpu", 10L, "ops/sec");
        network = newResource("net", "net", 1000L, "Mbit");
        hdd = newResource("hdd", "hdd", 100L, "io/sec");

        workUnit = new Payload("wu", "wu");
        io = new Payload("io", "io");
        message = new Payload("mes", "mes");

        consumptionMatrix = new SimpleConsumptionMatrix();
        consumptionMatrix.setConsumption(workUnit, cpu, 2000.0);

        consumptionMatrix.setConsumption(io, cpu, 500.0);
        consumptionMatrix.setConsumption(io, hdd, 5000.0);

        consumptionMatrix.setConsumption(message, cpu, 100.0);
        consumptionMatrix.setConsumption(message, hdd, 500.0);
        consumptionMatrix.setConsumption(message, network, 500.0);
    }

    @Test
    void testCalculate() {
        SimpleOverheadCalculator calculator = new SimpleOverheadCalculator();
        AbstractNode node = fillPayloadMatrix(new TestNode());

        OverheadMatrix matrix = calculator.calculate(consumptionMatrix, node);

        assertNotNull(matrix, "Invalid calculations state");
        assertEquals(205_100.0, matrix.getResourceMatrix().get(cpu), "Invalid calculations");
        assertEquals(50_500.0, matrix.getResourceMatrix().get(hdd), "Invalid calculations");
        assertEquals(500.0, matrix.getResourceMatrix().get(network), "Invalid calculations");
    }

    private Resource newResource(String id, String title, Long time, String unit) {
        Resource r = new Resource(id, title);
        r.setServiceTime(time);
        r.setServiceUnit(unit);
        return r;
    }

    private AbstractNode fillPayloadMatrix(AbstractNode node) {
        node.getPayloadMatrix().put(workUnit, 100.0);
        node.getPayloadMatrix().put(io, 10.0);
        node.getPayloadMatrix().put(message);
        return node;
    }

    static class TestNode extends AbstractNode {

        public TestNode() {
            super();
        }

        @Override
        public Matrix<Payload> calculatePayloadMatrix() {
            return payloadMatrix;
        }
    }
}
