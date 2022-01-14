package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

import com.isador.jspe.core.nodes.RepetitionNode;

public final class SimpleRepetitionNode extends AbstractCompoundNode implements RepetitionNode {

    @Serial
    private static final long serialVersionUID = 6138264215493634608L;

    private int repeatCount = 1;

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void removeRepeatCount() {
        repeatCount = 1;
    }
}
