module com.isador.jspe.adapters.simple {
    exports com.isador.jspe.adapters.simple;
    exports com.isador.jspe.adapters.simple.nodes;

    requires com.isador.jspe.core;

    provides com.isador.jspe.core.ModelBuilderFactory with
            com.isador.jspe.adapters.simple.SimpleModelBuilderFactory;
}
