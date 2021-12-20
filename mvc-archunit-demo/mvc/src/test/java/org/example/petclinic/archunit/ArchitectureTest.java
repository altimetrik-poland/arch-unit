package org.example.petclinic.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchRules;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.archunit.shared.SharedArchitectureTest;
import org.example.petclinic.PetclinicInitializer;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(importOptions = {ImportOption.DoNotIncludeArchives.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeTests.class})
public class ArchitectureTest {

    @ArchTest
    public static final ArchRules shared = ArchRules.in(SharedArchitectureTest.class);

    @ArchTest
    public static final ArchRule restControllerNamingRule = classes()
        .that()
        .resideInAPackage("..api..")
        .and()
        .haveSimpleNameEndingWith("Controller")
        .should()
        .beAnnotatedWith("org.springframework.stereotype.Controller");


    @ArchTest
    public static final ArchRule layeredArchitectureRule = Architectures.layeredArchitecture()
        .layer("Controller").definedBy("..api..")
        .layer("Service").definedBy("..service..")
        .layer("Persistence").definedBy("..repository..")

        .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
        .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");


    @ArchTest
    public static final ArchRule nodelShouldNotDependsOnOtherPacakges =
        noClasses()
            .that()
            .resideInAPackage("..model..")
            .should()
            .dependOnClassesThat()
            //.resideInAnyPackage("..api..", "..repository..","..service..");
            .resideOutsideOfPackages("..model..", "..java.*..","..javax.*..", "org.springframework.*..");


    @ArchTest
    public static final ArchRule nodelShouldNotDependsOnOtherPacakges2 =
        noClasses()
            .that()
            .resideInAPackage("..model..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..api..", "..repository..","..service..");
}
