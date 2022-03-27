package ru.isador.jspe.core;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

/** Полезная нагрузка. */
public class Payload implements Serializable {

    @Serial
    private static final long serialVersionUID = -5871713422371765004L;

    /** ID нагрузки. */
    private String id;

    /** Название нагрузки. */
    private String title;

    public Payload(String id, String title) {
        this.id = requireNonNull(id, "id should be not null");
        if (id.isBlank()) {
            throw new IllegalArgumentException("id should be not blank");
        }

        if (title != null && title.isBlank()) {
            throw new IllegalArgumentException("title should be not blank");
        }
        this.title = title;
    }

    /**
     * Создание объекта полезной нагрузки с рандомным ID и названием.
     *
     * @param title имя ресурса.
     *
     * @throws NullPointerException     если title == null.
     * @throws IllegalArgumentException если title.isBlank()
     * @see UUID
     * @since 1.0.0
     */
    public Payload(String title) {
        this(UUID.randomUUID().toString(), title);
    }

    //<editor-fold desc="g\s">
    public String getId() {
        return id;
    }

    /**
     * Задание нового ID.
     *
     * @param id новый ID.
     *
     * @throws NullPointerException     если ID == null
     * @throws IllegalArgumentException если id.isBlank()
     * @since 1.0.0
     */
    public void setId(String id) {
        requireNonNull(id, "id should be not null");
        if (id.isBlank()) {
            throw new IllegalArgumentException("id should be not blank");
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Задание нового названия.
     *
     * @param title название.
     *
     * @throws NullPointerException     если title == null.
     * @throws IllegalArgumentException если title.isBlank()
     * @since 1.0.0
     */
    public void setTitle(String title) {
        if (title != null && title.isBlank()) {
            throw new IllegalArgumentException("title should be not blank");
        }
        this.title = title;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payload payload = (Payload) o;
        return id.equals(payload.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Payload{" +
               "id='" + id + '\'' +
               ", title='" + title + '\'' +
               '}';
    }
}
