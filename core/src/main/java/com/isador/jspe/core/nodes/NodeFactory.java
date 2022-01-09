package com.isador.jspe.core.nodes;

public interface NodeFactory {

    <T extends BasicNode> T createBasicNode();

    <T extends CaseNode> T createCaseNode();

    <T extends ExpandedNode> T createExpandedNode();

    <T extends PardoNode> T createPardoNode();

    <T extends RepetitionNode> T createRepetitionNode();

    <T extends SplitNode> T createSplitNode();
}
