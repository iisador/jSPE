package ru.isador.jspe.adapters.dirty;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ru.isador.jspe.api.ComputerResourceRequirement;
import ru.isador.jspe.api.PerformanceScenario;
import ru.isador.jspe.api.Project;
import ru.isador.jspe.api.Scenario;

/**
 * Простая реализация, все объекты хранятся в полях класса.
 *
 * @since 1.0.0
 */
public class DirtyProject implements Project, Serializable {

   @Serial
   private static final long serialVersionUID = -826848791863138436L;

   private final Collection<Scenario> performanceScenario;
   private final Collection<Scenario> serviceScenario;
   private final Collection<ComputerResourceRequirement> computerResourceRequirement;

   private String name;

   /**
    * Создаёт объект класса, реализованный на ArrayList.
    */
   public DirtyProject(String name) {
      this.name = name;
      performanceScenario = new ArrayList<>();
      serviceScenario = new ArrayList<>();
      computerResourceRequirement = new ArrayList<>();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Collection<Scenario> getPerformanceScenarios() {
      return performanceScenario;
   }

   public Collection<Scenario> getServiceScenarios() {
      return serviceScenario;
   }

   public Collection<ComputerResourceRequirement> getComputerResourceRequirements() {
      return computerResourceRequirement;
   }
}
