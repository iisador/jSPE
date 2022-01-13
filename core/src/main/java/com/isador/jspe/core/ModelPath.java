package com.isador.jspe.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.isador.jspe.core.nodes.Node;

/**
 * Путь в модели.
 * Содержит коллекцию узлов системы.
 *
 * @since 2.0.0
 */
public interface ModelPath {

    double getTime();

    Collection<String> getNodes();
}
