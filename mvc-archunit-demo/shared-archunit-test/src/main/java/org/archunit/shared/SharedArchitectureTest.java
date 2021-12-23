package org.archunit.shared;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.lang.ArchRule;
import org.archunit.shared.tests.CodingRulesTest;
import org.archunit.shared.tests.CustomRules;
import org.archunit.shared.tests.NamingRulesTest;
import org.archunit.shared.tests.SliceTest;
import org.archunit.shared.tests.SpringBeanRulesTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class SharedArchitectureTest {

  @ArchTest
  public static final ArchTests naming_rules = ArchTests.in(NamingRulesTest.class);

  @ArchTest
  public static final ArchTests coding_rules = ArchTests.in(CodingRulesTest.class);

  @ArchTest
  public static final ArchTests sessionBean = ArchTests.in(SpringBeanRulesTest.class);

  @ArchTest
  public static final ArchRule deprecation_rule = classes()
      .should(CustomRules.notHaveFieldsAnnotatedWithDeprecated);

  @ArchTest
  public static final ArchTests slices_rule = ArchTests.in(SliceTest.class);



}
