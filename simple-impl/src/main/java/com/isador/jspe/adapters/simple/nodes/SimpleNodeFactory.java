package com.isador.jspe.adapters.simple.nodes;

import com.isador.jspe.core.nodes.BasicNode;
import com.isador.jspe.core.nodes.CaseNode;
import com.isador.jspe.core.nodes.ExpandedNode;
import com.isador.jspe.core.nodes.NodeFactory;
import com.isador.jspe.core.nodes.PardoNode;
import com.isador.jspe.core.nodes.RepetitionNode;
import com.isador.jspe.core.nodes.SplitNode;

public class SimpleNodeFactory implements NodeFactory {

    @Override
    public <T extends BasicNode> T createBasicNode() {
        return null;
    }

    @Override
    public <T extends CaseNode> T createCaseNode() {
        return null;
    }

    @Override
    public <T extends ExpandedNode> T createExpandedNode() {
        return null;
    }

    @Override
    public <T extends PardoNode> T createPardoNode() {
        return null;
    }

    @Override
    public <T extends RepetitionNode> T createRepetitionNode() {
        return null;
    }

    @Override
    public <T extends SplitNode> T createSplitNode() {
        return null;
    }
}
