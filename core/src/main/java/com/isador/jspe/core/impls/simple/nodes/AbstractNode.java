package com.isador.jspe.core.impls.simple.nodes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Node;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.impls.simple.NodesIterator;
import com.isador.jspe.core.impls.simple.SimpleMatrix;

import static java.util.Objects.requireNonNull;

/**
 * Общий класс для всех стандартных узлов модели.
 * Инкапсулирует в себе работу с общими полями узлов
 * (ID, описание, список потомков, матрица потребления).
 *
 * @since 1.0.0
 */
public abstract class AbstractNode implements Node, Serializable, Iterable<Node> {

    /** Список потомков. */
    protected final List<Node> childList;

    /** ID узла. */
    protected String id;

    /** Название узла. */
    protected String title;

    /** Матрица потребления. */
    protected final Matrix<Payload> payloadMatrix;

    /**
     * Инициализирует объект пустым списком потомков, и пустой матрицей потребления.
     *
     * @param id    ID узла.
     * @param title название узла.
     *
     * @see UUID
     * @since 1.0.0
     */
    public AbstractNode(final String id, final String title) {
        this.id = requireNonNull(id, "id should be not null");
        if (id.isBlank()) {
            throw new IllegalArgumentException("id should be not blank");
        }

        if (title != null && title.isBlank()) {
            throw new IllegalArgumentException("title should be not blank");
        }
        this.title = title;

        childList = new ArrayList<>();
        payloadMatrix = new SimpleMatrix<>();
    }

    /**
     * Инициализирует объект сгенерированным ID,
     * пустым списком потомков, и пустой матрицей потребления.
     *
     * @param title название узла.
     *
     * @see UUID
     * @since 1.0.0
     */
    public AbstractNode(String title) {
        this(UUID.randomUUID().toString(), title);
    }

    /**
     * Инициализирует объект сгенерированным ID, пустым названием,
     * пустым списком потомков, и пустой матрицей потребления.
     *
     * @see UUID
     * @since 1.0.0
     */
    public AbstractNode() {
        this(UUID.randomUUID().toString(), null);
    }

    /** {@inheritDoc} */
    @Override
    public void addChild(Node node) {
        requireNonNull(node, "Child node should be not null");

        childList.add(node);
    }

    /**
     * Итератор потомков.
     *
     * @return итератор, проходящий всех потомков рекурсивно.
     *
     * @since 1.0.0
     */
    @Override
    public Iterator<Node> iterator() {
        return new NodesIterator(this);
    }

    @Override
    public List<? extends Node> getChildList() {
        return childList;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Задать ID узла.
     *
     * @param id новый ID.
     *
     * @throws NullPointerException если новый ID == null.
     * @since 1.0.0
     */
    public void setId(String id) {
        this.id = requireNonNull(id, "id should be not null");
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.isBlank()) {
            throw new IllegalArgumentException("title should be not blank");
        }
        this.title = title;
    }

    @Override
    public Matrix<Payload> getPayloadMatrix() {
        return payloadMatrix;
    }

    /**
     * Вычисляет матрицу потребления узла и всех потомков.
     *
     * @return матрица потребления узла и потомков.
     *
     * @since 1.0.0
     */
    public abstract Matrix<Payload> calculatePayloadMatrix();

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractNode nodes = (AbstractNode) o;
        return id.equals(nodes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
