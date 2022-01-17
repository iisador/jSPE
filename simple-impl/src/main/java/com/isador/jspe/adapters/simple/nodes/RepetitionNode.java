package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

public final class RepetitionNode extends AbstractCompoundNode {

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
