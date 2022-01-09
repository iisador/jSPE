package com.isador.jspe.core.nodes;

import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;

public record NodeStatistic(Matrix<Payload> payload, Double time) {
}
