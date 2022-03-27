package ru.isador.jspe.core;

import java.util.Map;

/**
 * Статистика модели.
 * Содержит основные данные о модели и её оценку.
 */
public interface ModelStatistic {

    Map<Payload, Double> getTotalPayload();

    Map<Resource, Double> getTotalResource();

    ModelPath getMaxPath();

    ModelPath getMinPath();

    double getRating();
}
