package com.isador.jspe.adapters.simple;

import java.util.AbstractMap.SimpleEntry;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.ModelStatistic;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;
import com.isador.jspe.core.StatisticCalculator;

public class SimpleStatisticCalculator implements StatisticCalculator<SimpleModel> {

    @Override
    public ModelStatistic calculateStatistic(SimpleModel model) {
        ModelStatistic statistic = new ModelStatistic();

        Matrix<Payload> totalPayload = model.getNode()
                .orElseThrow(NullPointerException::new)
                .calculatePayloadMatrix();
        statistic.setTotalPayload(totalPayload);

        Matrix<Resource> totalResource = getResourceMatrix(model.getConsumptionMatrix(), totalPayload);
        statistic.setTotalResource(totalResource);

        Double rating = totalResource.entrySet().stream()
                .map(e -> e.getValue() * e.getKey().getServiceTime())
                .reduce(Double::sum)
                .orElse(0.0);
        statistic.setRating(rating);

        return statistic;
    }

    private Matrix<Resource> getResourceMatrix(ConsumptionMatrix consumption, Matrix<Payload> totalPayload) {
        Matrix<Resource> resourceMatrix = new SimpleMatrix<>();

        totalPayload.forEach((payload, payloadConsumption) -> consumption.getMappedResources(payload).stream()
                .map(resource -> new SimpleEntry<>(resource, consumption.getConsumption(payload, resource) * payloadConsumption))
                .forEach(e -> resourceMatrix.merge(e.getKey(), e.getValue(), Double::sum)));
        return resourceMatrix;
    }
}
