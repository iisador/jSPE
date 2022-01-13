package com.isador.jspe.adapters.simple;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.ModelStatistic;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;
import com.isador.jspe.core.StatisticCalculator;

public class SimpleStatisticCalculator implements StatisticCalculator<SimpleModel> {

    @Override
    public ModelStatistic calculate(SimpleModel model) {
        SimpleModelStatistic statistic = new SimpleModelStatistic();

        Map<Payload,Double> totalPayload = model.getNode()
                .orElseThrow(NullPointerException::new)
                .calculatePayloadMatrix();
        statistic.setTotalPayload(totalPayload);

        Map<Resource, Double> totalResource = getResourceMatrix(model.getConsumptionMatrix(), totalPayload);
        statistic.setTotalResource(totalResource);

        Double rating = totalResource.entrySet().stream()
                .map(e -> e.getValue() * e.getKey().getServiceTime())
                .reduce(Double::sum)
                .orElse(0.0);
        statistic.setRating(rating);

        return statistic;
    }

    private Map<Resource,Double> getResourceMatrix(ConsumptionMatrix consumption, Map<Payload, Double> totalPayload) {
        Map<Resource,Double> resourceMatrix = new HashMap<>();

        totalPayload.forEach((payload, payloadConsumption) -> consumption.getMappedResources(payload).stream()
                .map(resource -> new SimpleEntry<>(resource, consumption.getConsumption(payload, resource) * payloadConsumption))
                .forEach(e -> resourceMatrix.merge(e.getKey(), e.getValue(), Double::sum)));
        return resourceMatrix;
    }
}
