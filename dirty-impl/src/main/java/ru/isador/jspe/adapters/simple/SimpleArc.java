package ru.isador.jspe.adapters.simple;

import java.io.Serializable;

import ru.isador.jspe.api.Arc;
import ru.isador.jspe.api.nodes.Node;

/**
 * Простая реализация дуги.
 *
 * @since 1.0.0
 */
public class SimpleArc implements Arc, Serializable {

   private Node from;
   private Node to;

   public Node getFrom() {
      return from;
   }

   public void setFrom(Node from) {
      this.from = from;
   }

   public Node getTo() {
      return to;
   }

   public void setTo(Node to) {
      this.to = to;
   }
}
