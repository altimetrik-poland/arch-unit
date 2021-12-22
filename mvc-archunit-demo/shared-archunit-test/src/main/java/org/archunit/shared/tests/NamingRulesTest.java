package org.archunit.shared.tests;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class NamingRulesTest {

  @ArchTest
  static ArchRule classes_named_controller_should_be_in_a_controller_package =
      classes()
          .that()
          .haveSimpleNameContaining("Controller")
          .should()
          .resideInAPackage("..api..");

  @ArchTest
  static ArchRule classes_named_service_should_be_in_a_service_package =
      classes()
          .that()
          .haveSimpleNameContaining("Service")
          .should()
          .resideInAPackage("..service..");

  @ArchTest
  static ArchRule interface_classes_should_not_have_name_ending_with_interface =
      classes()
          .that()
          .areInterfaces()
          .should()
          .haveSimpleNameNotContaining("Interface")
          .because("Interface is already defined in class scope");


}
