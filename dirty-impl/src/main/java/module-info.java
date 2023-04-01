import ru.isador.jspe.adapters.dirty.DirtyProjectFactory;
import ru.isador.jspe.api.spi.ProjectFactory;

module ru.isador.jspe.adapters.simple {
    requires ru.isador.jspe.api;

    provides ProjectFactory with DirtyProjectFactory;
}
