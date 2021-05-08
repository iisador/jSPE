package com.isador.jspe.core;

public interface OverheadCalculator<T extends Node> {

    OverheadMatrix calculate(ConsumptionMatrix consumptionMatrix, T node);
}
