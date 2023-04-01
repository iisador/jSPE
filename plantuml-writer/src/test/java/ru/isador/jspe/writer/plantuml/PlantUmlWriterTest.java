package ru.isador.jspe.writer.plantuml;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.isador.jspe.api.facility.SoftwareResource;
import ru.isador.jspe.api.graph.ExecutionGraph;
import ru.isador.jspe.api.graph.HardwareResource;
import ru.isador.jspe.api.graph.OverheadMatrix;
import ru.isador.jspe.api.graph.nodes.BasicNode;
import ru.isador.jspe.api.graph.nodes.CaseNode;
import ru.isador.jspe.api.graph.nodes.Node;

class PlantUmlWriterTest {

    private final HardwareResource cpu = new HardwareResource("cpu", "CPU", "оп", 0.00001f);
    private final HardwareResource mem = new HardwareResource("mem", "MEM", "оп", 0.00001f);
    private final HardwareResource net = new HardwareResource("net", "Network", "кол/во", 120f);

    private final SoftwareResource workUnit = new SoftwareResource("wu", "Кило-операций");
    private final SoftwareResource dbQuery = new SoftwareResource("dbQuery", "Запрос в БД МФО");
    private final SoftwareResource httpQuery = new SoftwareResource("httpQuery", "HTTP запрос");

    private ExecutionGraph executionGraph;

    @BeforeEach
    void setUp() {
        executionGraph = new ExecutionGraph();
        executionGraph.setName("Test");

        OverheadMatrix overheadMatrix = executionGraph.getOverheadMatrix();

        overheadMatrix.addOverhead(workUnit, cpu, 1000);
        overheadMatrix.addOverhead(workUnit, mem, 250);
        overheadMatrix.addOverhead(dbQuery, cpu, 20000);
        overheadMatrix.addOverhead(dbQuery, net, 1);
        overheadMatrix.addOverhead(dbQuery, mem, 5000);
        overheadMatrix.addOverhead(httpQuery, cpu, 10000);
        overheadMatrix.addOverhead(httpQuery, net, 1);
        overheadMatrix.addOverhead(httpQuery, mem, 2500);


        Node getUserNode = getBasicNode("Получение информации о пользователе", 640.0f, 0.0f, 0.0f);
        Node getRightsNode = getBasicNode("Запрос прав на просмотр", 500.0f, 0.0f, 1.0f);
        Node errorOutputNode = getBasicNode("Вывод ошибки 'Недостаточно прав'", 100.0f, 0.0f, 0.0f);

        Node formingFilterNode = getBasicNode("Формирование фильтра", 20.0f, 0.0f, 0.0f);
        Node getDataCountNode = getBasicNode("Получение общего количества фильтрованных записей", 350.0f, 1.0f, 0.0f);
        Node getDataNode = getBasicNode("Получение фильтрованных записей", 21700.0f, 1.0f, 0.0f);

        Node getDataWithCount = getBasicNode("Получение фильтрованных записей + общее количество", 22000.0f, 1.0f, 0.0f);
        Node resultFormingNode = getBasicNode("Формирование результата", 45000.0f, 0.0f, 0.0f);
        CaseNode caseNode = new CaseNode();
        caseNode.setName("case");

//        executionGraph.setStartNode(getUserNode);
//        getUserNode.setChild(getRightsNode);
//        getRightsNode.setChild(caseNode);
//        caseNode.addCaseNode(errorOutputNode, 0.1f);
//        caseNode.addCaseNode(formingFilterNode, 0.9f);
//        formingFilterNode.setChild(getDataCountNode);
//        getDataCountNode.setChild(getDataNode);
//        caseNode.setChild(resultFormingNode);

                executionGraph.setStartNode(getUserNode);
                getUserNode.setChild(getRightsNode);
                getRightsNode.setChild(caseNode);
                caseNode.addCaseNode(errorOutputNode, 0.1f);
                caseNode.addCaseNode(formingFilterNode, 0.9f);
                formingFilterNode.setChild(getDataWithCount);
                caseNode.setChild(resultFormingNode);
    }

    @Test
    void testMain() throws IOException {
        PlantUmlWriter writer = new PlantUmlWriter(Paths.get("test.svg"));
        writer.writeExecutionGraph(executionGraph);
    }

    private Node getBasicNode(String name, float workUnitAmount, float dbQueryAmount, float httpAmount) {
        Node node = new BasicNode(name);
        if (Float.compare(workUnitAmount, 0.0f) > 0) {
            node.getSoftwareResourceRequirements().addRequirement(workUnit, workUnitAmount);
        }
        if (Float.compare(dbQueryAmount, 0.0f) > 0) {
            node.getSoftwareResourceRequirements().addRequirement(dbQuery, dbQueryAmount);
        }
        if (Float.compare(httpAmount, 0.0f) > 0) {
            node.getSoftwareResourceRequirements().addRequirement(httpQuery, httpAmount);
        }
        return node;
    }
}
