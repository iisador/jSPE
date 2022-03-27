module ru.isador.jspe.adapters.simple {
    exports ru.isador.jspe.adapters.simple;
    exports ru.isador.jspe.adapters.simple.nodes;

    requires ru.isador.jspe.core;

    provides ru.isador.jspe.core.ModelBuilderFactory with
            ru.isador.jspe.adapters.simple.SimpleModelBuilderFactory;
}
