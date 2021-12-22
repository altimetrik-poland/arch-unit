package org.example.petclinic.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.archunit.shared.SharedArchitectureTest;

@AnalyzeClasses(packages = "org.example.petclinic", importOptions = {ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeTests.class})
public class ArchitectureTest {

  @ArchTest
  public static final ArchTests session = ArchTests.in(SharedArchitectureTest.class);


  @ArchTest
  public static final ArchRule layeredArchitectureRule = Architectures.layeredArchitecture()
      .layer("Controller").definedBy("..api..")
      .layer("Service").definedBy("..service..")
      .layer("Persistence").definedBy("..repository..")

      .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
      .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
      .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

  //.ignoreDependency(VisitController.class, VisitRepository.class);
}
