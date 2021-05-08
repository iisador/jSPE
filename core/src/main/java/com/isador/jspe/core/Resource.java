package com.isador.jspe.core;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

/** Ресурс системы. */
public class Resource implements Serializable {

    /** ID ресурса. */
    private String id;

    /** Название. */
    private String title;

    /** Единица измерения. */
    private String serviceUnit;

    /** Время обслуживания. */
    private Long serviceTime;

    /**
     * Создание объекта ресурса.
     *
     * @param id    ID нового ресурса
     * @param title имя ресурса
     *
     * @throws NullPointerException     если ID == null или title == null
     * @throws IllegalArgumentException если id.isBlank() или title.isBlank()
     * @since 1.0.0
     */
    public Resource(String id, String title) {
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
     * Создание объекта ресурса с рандомным ID и названием.
     *
     * @param title имя ресурса.
     *
     * @throws NullPointerException     если title == null
     * @throws IllegalArgumentException если title.isBlank()
     * @see UUID
     * @since 1.0.0
     */
    public Resource(String title) {
        this(UUID.randomUUID().toString(), title);
    }

    public Resource() {
        this(UUID.randomUUID().toString(), null);
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

    public Long getServiceTime() {
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
    public void setServiceTime(Long serviceTime) {
        if (serviceTime != null && serviceTime < 0) {
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
