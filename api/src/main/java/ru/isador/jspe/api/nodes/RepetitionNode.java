package ru.isador.jspe.api.nodes;

/**
 * Узел с циклом.
 *
 * @since 1.0.0
 */
public class RepetitionNode extends CompoundNode {

    private float repetitionFactor;

    public float getRepetitionFactor() {
        return repetitionFactor;
    }

    public void setRepetitionFactor(float value) {
        this.repetitionFactor = value;
    }
}
