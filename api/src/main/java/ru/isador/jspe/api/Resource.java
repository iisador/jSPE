package ru.isador.jspe.api;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

/** Ресурс системы. */
public class Resource implements Serializable {

    @Serial
    private static final long serialVersionUID = 1700922042818109439L;

    /** ID ресурса. */
    private String id;

    /** Название. */
    private String title;

    /** Единица измерения. */
    private String serviceUnit;

    /** Время обслуживания. */
    private Double serviceTime;

    /**
     * Создание объекта ресурса.
     *
     * @param id    ID нового ресурса
     *
     * @throws NullPointerException     если ID == null
     * @since 1.0.0
     */
    public Resource(String id) {
        this.id = requireNonNull(id, "id should be not null");
        if (id.isBlank()) {
            throw new IllegalArgumentException("id should be not blank");
        }
    }

    /**
     * Создание объекта ресурса с рандомным ID.
     *
     * @see UUID
     * @since 1.0.0
     */
    public Resource() {
        this(UUID.randomUUID().toString());
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

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    public Double getServiceTime() {
        return serviceTime;
    }

    /**
     * Задание времени обслуживания.
     *
     * @param serviceTime время обслуживания
     *
     * @throws IllegalArgumentException если новое время обслуживания < 0
     * @since 1.0.0
     */
    public void setServiceTime(Double serviceTime) {
        if (serviceTime != null && Double.compare(serviceTime, 0.0) < 0) {
            throw new IllegalArgumentException("Service time should be >= 0");
        }
        this.serviceTime = serviceTime;
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
        Resource resource = (Resource) o;
        return id.equals(resource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Resource{" +
               "id='" + id + '\'' +
               ", title='" + title + '\'' +
               ", serviceUnit='" + serviceUnit + '\'' +
               ", serviceTime=" + serviceTime +
               '}';
    }
}
