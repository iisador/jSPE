package com.isador.jspe.adapters.simple;

import java.io.Serial;

import com.isador.jspe.adapters.simple.nodes.AbstractNode;
import com.isador.jspe.core.Payload;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractNodeTest {

    @Test
    void testConstructorIdTitle() {
        Exception e = assertThrows(NullPointerException.class, () -> new AbstractTestNode(null, null));
        assertEquals("id should be not null", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> new AbstractTestNode("", null));
        assertEquals("id should be not blank", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> new AbstractTestNode("123", ""));
        assertEquals("title should be not blank", e.getMessage());

        AbstractNode node = new AbstractTestNode("123", "123");
        assertEquals("123", node.getId(), "Invalid node id");
        assertEquals("123", node.getTitle(), "Invalid node title");
        assertNotNull(node.getPayloadMatrix(), "Invalid node payload matrix");
        assertTrue(node.getPayloadMatrix().isEmpty(), "Payload matrix should be empty");
        assertNotNull(node.getChildList(), "Invalid node child list");
        assertTrue(node.getChildList().isEmpty(), "Child list should be empty");
    }

    @Test
    void testConstructorTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new AbstractTestNode(""));
        assertEquals("title should be not blank", e.getMessage());

        AbstractNode node = new AbstractTestNode("123");
        assertNotNull(node.getId(), "Invalid node id");
        assertEquals("123", node.getTitle(), "Invalid node title");
        assertNotNull(node.getPayloadMatrix(), "Invalid node payload matrix");
        assertTrue(node.getPayloadMatrix().isEmpty(), "Payload matrix should be empty");
        assertNotNull(node.getChildList(), "Invalid node child list");
        assertTrue(node.getChildList().isEmpty(), "Child list should be empty");
    }

    @Test
    void testConstructor() {
        AbstractNode node = new AbstractTestNode();

        assertNotNull(node.getId(), "Invalid node id");
        assertNull(node.getTitle(), "Invalid node title");
        assertNotNull(node.getPayloadMatrix(), "Invalid node payload matrix");
        assertTrue(node.getPayloadMatrix().isEmpty(), "Payload matrix should be empty");
        assertNotNull(node.getChildList(), "Invalid node child list");
        assertTrue(node.getChildList().isEmpty(), "Child list should be empty");
    }

    @Test
    void testSetId() {
        AbstractNode node = new AbstractTestNode();

        NullPointerException e = assertThrows(NullPointerException.class, () -> node.setId(null));
        assertEquals("id should be not null", e.getMessage());

        node.setId("id");
        assertEquals("id", node.getId(), "Invalid node id");
    }

    @Test
    void testSetTitle() {
        AbstractNode node = new AbstractTestNode();

        Exception e = assertThrows(IllegalArgumentException.class, () -> node.setTitle(""));
        assertEquals("title should be not blank", e.getMessage());

        node.setTitle("123");
        assertEquals("123", node.getTitle(), "Invalid node title");
    }

    @Test
    void testAddChild() {
        AbstractNode node = new AbstractTestNode();
        Exception e = assertThrows(NullPointerException.class, () -> node.addChild(null));
        assertEquals("Child node should be not null", e.getMessage());
        assertTrue(node.getChildList().isEmpty(), "Invalid child list size");

        AbstractNode child = new AbstractTestNode("ch1", "ch1");
        node.addChild(child);
        assertEquals(1, node.getChildList().size(), "Invalid child list size");

        node.getChildList().remove(new AbstractTestNode("ch2", "ch2"));
        assertEquals(1, node.getChildList().size(), "Invalid child list size");

        node.getChildList().remove(child);
        assertTrue(node.getChildList().isEmpty(), "Invalid child list size");
    }

    @Test
    void testIterator() {
        assertNotNull(new AbstractTestNode().iterator(), "Node should always return iterator");
    }

    @Test
    void testEqualsHashCode() {
        EqualsVerifier.simple().forClass(AbstractNode.class)
                .withNonnullFields("id")
                .withOnlyTheseFields("id")
                .verify();
    }

    private static final class AbstractTestNode extends AbstractNode {

        @Serial
        private static final long serialVersionUID = -5875927212044670286L;

        public AbstractTestNode(String id, String title) {
            super(id, title);
        }

        public AbstractTestNode(String title) {
            super(title);
        }

        public AbstractTestNode() {
            super();
        }

        @Override
        public Matrix<Payload> calculatePayloadMatrix() {
            return Matrix.emptyMatrix();
        }
    }
}
