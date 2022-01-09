package com.isador.jspe.core;

/**
 * Статистика модели.
 * Содержит основные данные о модели и её оценку.
 */
public class ModelStatistic {

    /** Общее количество полезной нагрузки. */
    private Matrix<Payload> totalPayload;

    /** Общее количество потребляемых ресурсов. */
    private Matrix<Resource> totalResource;

    /** Максимальный путь. */
    private ModelPath maxPath;

    /** Минимальный путь. */
    private ModelPath minPath;

    /** Оценка модели. */
    private Double rating;

    //<editor-fold desc="g\s">
    public Matrix<Payload> getTotalPayload() {
        return totalPayload;
    }

    public void setTotalPayload(Matrix<Payload> totalPayload) {
        this.totalPayload = totalPayload;
    }

    public Matrix<Resource> getTotalResource() {
        return totalResource;
    }

    public void setTotalResource(Matrix<Resource> totalResource) {
        this.totalResource = totalResource;
    }

    public ModelPath getMaxPath() {
        return maxPath;
    }

    public void setMaxPath(ModelPath maxPath) {
        this.maxPath = maxPath;
    }

    public ModelPath getMinPath() {
        return minPath;
    }

    public void setMinPath(ModelPath minPath) {
        this.minPath = minPath;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    //</editor-fold>
}
