package ru.isador.jspe.api.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.isador.jspe.api.facility.SoftwareResource;
import ru.isador.jspe.api.graph.nodes.BasicNode;
import ru.isador.jspe.api.graph.nodes.CaseNode;
import ru.isador.jspe.api.graph.nodes.Node;

class ExecutionGraphTest {

    HardwareResource cpu;
    HardwareResource hdd;
    HardwareResource net;

    SoftwareResource workUnit;
    SoftwareResource dbQuery;
    SoftwareResource message;

    private ExecutionGraph executionGraph;

    @BeforeEach
    void setUp() {
        executionGraph = new ExecutionGraph();
        executionGraph.setName("Test");

        cpu = new HardwareResource("cpu", "CPU", "k/instr", 0.0001f);
        hdd = new HardwareResource("hdd", "HDD", "i/o", 0.01f);
        net = new HardwareResource("net", "Network", "i/o", 0.001f);

        workUnit = new SoftwareResource("wu", "Work unit");
        dbQuery = new SoftwareResource("dbQuery", "DB query");
        message = new SoftwareResource("queueMessage", "Queue message");
    }

    @Test
    void testTime() {
        long start = System.nanoTime();
        int a = 5;
        long elapsed = System.nanoTime() - start;
        System.out.println(elapsed + "\n" + TimeUnit.NANOSECONDS.toMillis(elapsed));
    }
    @Test
    void testMain() {
        OverheadMatrix overheadMatrix = executionGraph.getOverheadMatrix();

        overheadMatrix.addOverhead(workUnit, cpu, 1000);

        overheadMatrix.addOverhead(dbQuery, cpu, 5000);
        overheadMatrix.addOverhead(dbQuery, net, 1);

        overheadMatrix.addOverhead(message, cpu, 3000);
        overheadMatrix.addOverhead(message, hdd, 1);
        overheadMatrix.addOverhead(message, net, 1);

        Node authNode = getBasicNode("User authentication", 500.0f, 0.0f, 1.0f);
        Node getOperationNode = getBasicNode("Get operation type", 50.0f, 0.0f, 0.0f);
        Node logOperationNode = getBasicNode("Log operation", 100.0f, 0.0f, 1.0f);
        Node getBalanceNode = getBasicNode("Get balance", 100.0f, 1.0f, 0.0f);
        Node payNode = getBasicNode("Pay", 1000.0f, 3.0f, 1.0f);
        Node cancelNode = getBasicNode("Cancel", 500.0f, 3.0f, 1.0f);
        Node getCartNode = getBasicNode("Get cart", 500.0f, 1.0f, 0.0f);
        Node addToCartNode = getBasicNode("Add to cart", 1000.0f, 3.0f, 1.0f);
        Node prepareAnswerNode = getBasicNode("Prepare answer", 5000.0f, 5.0f, 5.0f);
        CaseNode caseNode = new CaseNode();

        executionGraph.setStartNode(authNode);
        authNode.setChild(getOperationNode);
        getOperationNode.setChild(logOperationNode);
        logOperationNode.setChild(caseNode);
        caseNode.addCaseNode(getBalanceNode, 0.3f);
        caseNode.addCaseNode(cancelNode, 0.1f);
        caseNode.addCaseNode(getCartNode, 0.8f);
        getBalanceNode.setChild(payNode);
        getCartNode.setChild(addToCartNode);
        caseNode.setChild(prepareAnswerNode);

        System.out.printf("Min time: %.1f; Min path: %s%n", executionGraph.getMinTime(), pathToString(executionGraph.getMinPath()));
        System.out.printf("Max time: %.1f; Max path: %s%n", executionGraph.getMaxTime(), pathToString(executionGraph.getMaxPath()));
        System.out.printf("Avg time: %.1f; %n", executionGraph.getAvgTime());
    }

    private String pathToString(Node startNode) {
        StringBuilder sb = new StringBuilder();
        Node n = startNode;
        while (n != null) {
            if(n instanceof CaseNode) {
                sb.append(pathToString(((CaseNode) n).getFirstCase())).append(" -> ");
            } else {
                sb.append(n.toString(executionGraph.getOverheadMatrix())).append(" -> ");
            }
            n = n.getChild();
        }
        sb.delete(sb.length() - 4, sb.length());
        return sb.toString();
    }

    private Node getBasicNode(String name, float workUnitAmount, float dbQueryAmount, float queueMessageAmount) {
        Node node = new BasicNode(name);
        if (Float.compare(workUnitAmount, 0.0f) > 0) {
            node.getSoftwareResourceRequirements().addRequirement(workUnit, workUnitAmount);
        }
        if (Float.compare(dbQueryAmount, 0.0f) > 0) {
            node.getSoftwareResourceRequirements().addRequirement(dbQuery, dbQueryAmount);
        }
        if (Float.compare(queueMessageAmount, 0.0f) > 0) {
            node.getSoftwareResourceRequirements().addRequirement(message, queueMessageAmount);
        }
        return node;
    }
}
