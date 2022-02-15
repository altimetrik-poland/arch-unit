package org.example.petclinic.archunit;


import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "org.example.petclinic", importOptions = {ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeTests.class})
public class SimpleTest {

    @ArchTest
    private ArchRule fieldsShouldNotBePublic =
            ArchRuleDefinition.fields()
                    .that()
                    .areDeclaredInClassesThat(DescribedPredicate.not(JavaClass.Predicates.ENUMS))
                    .should()
                    .notBePublic()
                    .because("because of encapsulation");
}
