package ru.isador.jspe.core;

/** Интерфейс подсчета статистики по модели. */
public interface StatisticCalculator<T extends SpeModel> {

    /**
     * Вычисление статистики модели.
     *
     * @param model модель, для которой необходимо получить статистические данные.
     *
     * @return статистические данные модели.
     *
     * @since 2.0.0
     */
    ModelStatistic calculate(T model);
}
