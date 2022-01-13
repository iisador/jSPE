package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public abstract class AbstractCompoundNode extends AbstractNode {

    @Serial
    private static final long serialVersionUID = -4308360272398863165L;

    protected final List<AbstractNode> childs;

    public AbstractCompoundNode(String id, String title) {
        super(id, title);
        this.childs = new ArrayList<>();
    }

    public AbstractCompoundNode(String title) {
        super(title);
        this.childs = new ArrayList<>();
    }

    public AbstractCompoundNode() {
        this.childs = new ArrayList<>();
    }

    public void addChild(AbstractNode child) {
        requireNonNull(child, "child should be not null");
        childs.add(child);
    }

    public void removeChild(AbstractNode child) {
        childs.remove(child);
    }

    public List<AbstractNode> getChilds() {
        return childs;
    }
}
