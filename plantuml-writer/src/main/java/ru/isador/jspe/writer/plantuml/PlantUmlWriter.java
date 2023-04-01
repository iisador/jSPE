package ru.isador.jspe.writer.plantuml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import ru.isador.jspe.api.facility.SoftwareResource;
import ru.isador.jspe.api.graph.ExecutionGraph;
import ru.isador.jspe.api.graph.HardwareResource;
import ru.isador.jspe.api.graph.OverheadMatrix;
import ru.isador.jspe.api.graph.nodes.CaseNode;
import ru.isador.jspe.api.graph.nodes.Node;
import ru.isador.jspe.api.graph.nodes.ProcessingNode;

public class PlantUmlWriter {

    private final Path outputPath;

    private boolean printMaxPath;
    private boolean printMinPath;
    private boolean printAvgTime;
    private boolean printSoftwareRequirements;
    private boolean printOverheadMatrix;
    private boolean printNodeTime;

    public PlantUmlWriter(Path outputPath) {
        this.outputPath = outputPath;
        printMaxPath = true;
        printMinPath = true;
        printAvgTime = true;
        printSoftwareRequirements = true;
        printOverheadMatrix = true;
        printNodeTime = true;
    }

    public void writeExecutionGraph(ExecutionGraph executionGraph) throws IOException {
        StringBuilder sb = new StringBuilder("""
                @startuml
                skinparam ranksep 20
                """);
        sb.append("\ntitle ").append(executionGraph.getName()).append("\n\n");

        printNode(sb, executionGraph.getOverheadMatrix(), executionGraph.getStartNode(), null, null);
        sb.append("\n");

        printConnections(sb, executionGraph, executionGraph.getOverheadMatrix(), executionGraph.getStartNode(), null);
        if (printOverheadMatrix || printMinPath || printMaxPath || printAvgTime) {
            fillLegend(sb, executionGraph);
        }

        sb.append("@enduml\n");
        System.out.println(sb);
        SourceStringReader sourceStringReader = new SourceStringReader(sb.toString());
        sourceStringReader.outputImage(Files.newOutputStream(outputPath), new FileFormatOption(FileFormat.SVG));
    }

    private void printNode(StringBuilder sb, OverheadMatrix overheadMatrix, Node node, String prefix, Float probability) {
        if (ProcessingNode.class.isAssignableFrom(node.getClass())) {
            sb.append(String.format("map \"%s\" as %s {%n", node.getName(), genNodeId(node, prefix)));
            if (printSoftwareRequirements) {
                node.getSoftwareResourceRequirements().getResourceRequirements().forEach((sr, q) -> sb.append(String.format("  %s => %.1f%n", sr.getName(), q)));
            }
            if (probability != null) {
                sb.append(String.format("  Probability => %.1f%n", probability));
            }
            if (printNodeTime) {
                sb.append(String.format("  Node Time => %.1f%n", node.getSoftwareResourceRequirements().getTime(overheadMatrix)));
            }
            sb.append("}\n");

        } else if (node instanceof CaseNode) {
            ((CaseNode) node).getCaseNodes().forEach((n, p) -> {
                printNode(sb, overheadMatrix, n, genNodeId(node, prefix), p);
            });
        }

        if (node.getChild() != null) {
            printNode(sb, overheadMatrix, node.getChild(), prefix, null);
        }
    }

    private void printConnections(StringBuilder sb, ExecutionGraph executionGraph, OverheadMatrix overheadMatrix, Node node, String prefix) {
        if (ProcessingNode.class.isAssignableFrom(node.getClass())) {
            if (node.getChild() != null) {
                String nodeId = genNodeId(node, prefix);
                if (ProcessingNode.class.isAssignableFrom(node.getChild().getClass())) {
                    String childNodeId = genNodeId(node.getChild(), prefix);
                    if (prefix != null) {
                        sb.append(String.format("%s -> %s%n", nodeId, childNodeId));
                    } else {
                        sb.append(String.format("%s --> %s%n", nodeId, childNodeId));
                    }
                } else if (node.getChild() instanceof CaseNode caseNode) {
                    caseNode.getCaseNodes().keySet().forEach(n -> {
                        String childNodeId = genNodeId(n, genNodeId(caseNode, prefix));
                        sb.append(String.format("%s --> %s%n", nodeId, childNodeId));
                        printConnections(sb, executionGraph, overheadMatrix, n, genNodeId(caseNode, prefix));
                    });
                }
                printConnections(sb, executionGraph, overheadMatrix, node.getChild(), prefix);
            }
        }
    }

    //    private boolean isNodeIdInPath(Node startNode, String nodeId) {
    //
    //    }

    private String genNodeId(Node n, String prefix) {
        if (prefix != null) {
            return prefix + "." + n.getName().replace(' ', '_').toLowerCase();
        }
        return n.getName().replace(' ', '_').toLowerCase();
    }

    private void fillLegend(StringBuilder sb, ExecutionGraph executionGraph) {
        sb.append("legend\n");

        if (printOverheadMatrix) {
            printOverheadMatrix(sb, executionGraph);
        }

        if (printMaxPath) {
            sb.append(String.format("| **Максимальное время выполнения** | %.2f (ms) | <font color=\"red\">——————→</font> |%n", executionGraph.getMaxTime()));
        }

        if (printMinPath) {
            sb.append(String.format("| **Минимальное время выполнения** | %.2f (ms) | <font color=\"green\">——————→</font> |%n", executionGraph.getMinTime()));
        }

        if (printAvgTime) {
            sb.append(String.format("| **Среднее время выполнения** | %.2f (ms)| ——————→ |%n", executionGraph.getAvgTime()));
        }

        sb.append("endlegend\n\n");
    }

    private void printOverheadMatrix(StringBuilder sb, ExecutionGraph executionGraph) {
        sb.append("Матрица накладных расходов\n");
        OverheadMatrix overheadMatrix = executionGraph.getOverheadMatrix();

        Collection<HardwareResource> hwResources = overheadMatrix.getHardwareResources();
        StringBuilder hwNames = new StringBuilder("| |");
        StringBuilder hwServiceTime = new StringBuilder("| **Service time (ms)** |");
        hwResources.forEach(hwr -> {
            hwNames.append(String.format(" **%s (%s)** |", hwr.getName(), hwr.getMeasure()));
            hwServiceTime.append(" ").append(String.format("%.5f", hwr.getServiceTime())).append(" |");
        });
        hwNames.append('\n');
        hwServiceTime.append('\n');

        sb.append(hwNames);

        Collection<SoftwareResource> swResources = overheadMatrix.getSoftwareResources();
        swResources.forEach(swr -> {
            StringBuilder swrRow = new StringBuilder("| **" + swr.getName() + "** |");
            hwResources.forEach(hwr -> swrRow.append(" ").append(overheadMatrix.getAmount(swr, hwr)).append(" |"));
            swrRow.append('\n');
            sb.append(swrRow);
        });
        sb.append(hwServiceTime).append("\n");
    }

    public void setPrintMaxPath(boolean printMaxPath) {
        this.printMaxPath = printMaxPath;
    }

    public void setPrintMinPath(boolean printMinPath) {
        this.printMinPath = printMinPath;
    }

    public void setPrintAvgTime(boolean printAvgTime) {
        this.printAvgTime = printAvgTime;
    }

    public void setPrintSoftwareRequirements(boolean printSoftwareRequirements) {
        this.printSoftwareRequirements = printSoftwareRequirements;
    }

    public void setPrintOverheadMatrix(boolean printOverheadMatrix) {
        this.printOverheadMatrix = printOverheadMatrix;
    }

    public void setPrintNodeTime(boolean printNodeTime) {
        this.printNodeTime = printNodeTime;
    }
}
