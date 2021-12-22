package org.archunit.shared.tests;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.util.logging.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

public class CodingRulesTest {

  @ArchTest
  private final ArchRule no_access_to_standard_streams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

  @ArchTest
  private final ArchRule no_generic_exceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

  @ArchTest
  private final ArchRule no_java_util_logging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

  @ArchTest
  private final ArchRule loggers_should_be_private_static_final =
      fields().that().haveRawType(Logger.class)
          .should().bePrivate()
          .andShould().beStatic()
          .andShould().beFinal()
          .because("we agreed on this convention");

  @ArchTest
  private final ArchRule fields_should_be_private =
      fields()
          .that()
          .areDeclaredInClassesThat(DescribedPredicate.not(JavaClass.Predicates.ENUMS))
          .should()
          .notBePublic()
          .because("we agreed on this convention");

  @ArchTest
  private final ArchRule no_jodatime = NO_CLASSES_SHOULD_USE_JODATIME;

  @ArchTest
  private final ArchRule no_field_injection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
}
