package ru.isador.jspe.api.node.processing.synchronization;

import ru.isador.jspe.api.node.processing.ProcessingNode;

public interface SynchronizationNode extends ProcessingNode {

    String getReceiverPerfScenarioName();

    void setReceiverPerfScenarioName(String receiverPerfScenarioName);

    ReceiveNode getReceiver();

    void setReceiver(ReceiveNode receiver);

    String getReceiverType();

    void setReceiverType(String receiverType);
}
