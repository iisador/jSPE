package com.isador.jspe.adapters.simple;

import com.isador.jspe.core.ModelBuilder;
import com.isador.jspe.core.ModelBuilderFactory;

public class SimpleModelBuilderFactory implements ModelBuilderFactory {

    @Override
    public ModelBuilder get() {
        return new SimpleModelBuilder();
    }
}
