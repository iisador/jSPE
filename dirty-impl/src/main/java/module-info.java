import ru.isador.jspe.adapters.simple.SimpleProjectFactory;
import ru.isador.jspe.api.spi.ProjectFactory;

module ru.isador.jspe.adapters.simple {
    requires ru.isador.jspe.api;

    provides ProjectFactory with SimpleProjectFactory;
}