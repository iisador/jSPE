package com.isador.jspe.core.impls.simple;

import com.isador.jspe.core.Node;
import com.isador.jspe.core.impls.simple.nodes.TestNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodesIteratorTest {

    @Test
    @DisplayName("Iterate over valid model")
    void testValidModel() {
        Node node0 = new TestNode();
        Node node1 = new TestNode();
        Node node2 = new TestNode();
        node0.addChild(node1);
        node1.addChild(node2);

        NodesIterator it = new NodesIterator(node0);
        int nodesCount = 0;
        while (it.hasNext()) {
            it.next();
            nodesCount++;
        }

        assertEquals(3, nodesCount, "Iterator has been to traverse all nodes");
        assertTrue(it.getCyclicNode().isEmpty(), "No cyclic node should be returned");
    }

    @Test
    @DisplayName("Iterate over cyclic model")
    void testCyclicModel() {
        Node node0 = new TestNode();
        Node node1 = new TestNode();
        Node node2 = new TestNode();
        node0.addChild(node1);
        node1.addChild(node2);
        node2.addChild(node0);

        NodesIterator it = new NodesIterator(node0);
        int nodesCount = 0;
        while (it.hasNext()) {
            it.next();
            nodesCount++;
        }

        assertEquals(3, nodesCount, "Iterator has been to traverse all nodes");
        assertTrue(it.getCyclicNode().isPresent(), "Cyclic node should be detected");
        assertEquals(node0, it.getCyclicNode().get(), "Invalid cyclic node");
    }
}
