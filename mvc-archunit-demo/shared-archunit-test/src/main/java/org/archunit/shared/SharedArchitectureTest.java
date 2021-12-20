package org.archunit.shared;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(importOptions = {ImportOption.DoNotIncludeArchives.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeTests.class})
public class SharedArchitectureTest {

    @ArchTest
    public static final ArchRule deprecationRule = classes()
        .should(CustomRules.notHaveFieldsAnnotatedWithDeprecated);

    @ArchTest
    public static final ArchRule application_should_be_free_of_cycles = slices().matching("org.(*)..").should().beFreeOfCycles();

}
