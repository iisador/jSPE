package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.nodes.Node;

import static java.util.Collections.emptyMap;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;

/**
 * Общий класс для всех стандартных узлов модели.
 * Инкапсулирует в себе работу с общими полями узлов
 * (ID, описание, список потомков, матрица потребления).
 *
 * @since 1.0.0
 */
public abstract class AbstractNode implements Node {

    @Serial
    private static final long serialVersionUID = 417153637595528688L;
    /** Матрица потребления. */
    protected final Map<Payload, Double> payloadMap;

    /** Следующий узел модели. */
    protected AbstractNode next;

    /** ID узла. */
    protected String id;

    /** Название узла. */
    protected String title;

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
        payloadMap = new HashMap<>();
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
    public Map<Payload, Double> getPayloadMap() {
        return payloadMap;
    }

    /**
     * Вычисляет матрицу потребления узла и всех потомков.
     *
     * @return матрица потребления узла и потомков.
     *
     * @since 1.0.0
     */
    public Map<Payload, Double> calculatePayloadMatrix() {
        return emptyMap();
    }

    protected Map<Payload, Double> plus(Map<Payload, Double> m1, Map<Payload, Double> m2) {
        Set<Payload> payloads = new HashSet<>();
        payloads.addAll(m1.keySet());
        payloads.addAll(m2.keySet());

        return payloads.stream()
                .map(p -> new AbstractMap.SimpleEntry<>(p, m1.getOrDefault(p, 0.0) + m2.getOrDefault(p, 0.0)))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    public AbstractNode getNext() {
        return next;
    }

    public void setNext(AbstractNode next) {
        this.next = next;
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
