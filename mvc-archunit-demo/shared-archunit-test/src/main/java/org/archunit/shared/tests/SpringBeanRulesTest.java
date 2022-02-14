package org.archunit.shared.tests;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.AccessTarget;
import com.tngtech.archunit.core.domain.JavaAccess;
import com.tngtech.archunit.core.domain.JavaAccess.Functions.Get;
import com.tngtech.archunit.core.domain.JavaAnnotation;
import com.tngtech.archunit.core.domain.JavaFieldAccess;
import com.tngtech.archunit.core.domain.properties.HasOwner;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.util.List;

import static com.tngtech.archunit.base.DescribedPredicate.not;
import static com.tngtech.archunit.core.domain.JavaAccess.Predicates.originOwnerEqualsTargetOwner;
import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class SpringBeanRulesTest {

  @ArchTest
  public static final ArchRule classes_named_service_should_be_annotated_with_service =
      classes()
          .that()
          .resideInAPackage("..service..")
          .and()
          .areNotInterfaces()
          .should()
          .beAnnotatedWith("org.springframework.stereotype.Service");

  @ArchTest
  public static final ArchRule classes_named_controller_should_be_annotated_with_controller =
      classes()
          .that()
          .resideInAPackage("..api..")
          .and()
          .haveSimpleNameEndingWith("Controller")
          .should()
          .beAnnotatedWith("org.springframework.stereotype.Controller");

  @ArchTest
  static final ArchRule stateless_session_beans_should_not_have_state =
      classes()
          .that()
          .areAnnotatedWith("org.springframework.stereotype.Service")
          .should()
          .haveOnlyFinalFields();
}