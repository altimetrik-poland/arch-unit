package org.example.user;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = {"org.example.user"},
        importOptions = {ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeTests.class})
public class UserArchitectureTest {

    @ArchTest
    public static final ArchRule hexagonalArchitectureConstraints = onionArchitecture()
            .domainModels("org.example.user.core.model..")
            .domainServices("org.example.user.core..")
            .applicationServices("org.example.user.application..")
            .adapter("persistence", "org.example.user.infrastructure.persistence..")
            .adapter("rest", "org.example.user.infrastructure.rest..");



    @ArchTest
    public static final ArchRule domainRuleConstraints =
            classes()
                    .that()
                    .resideInAPackage("..core..")
                    .should()
                    .onlyDependOnClassesThat()
                    .resideInAnyPackage("..core..", "java..");

/*
    @ArchTest
    public static final ArchRule adaptersConstraints =
            classes()
                    .that()
                    .resideInAPackage("..org.example.user.infrastructure..")
                    .should()
                    .bePackagePrivate();
    */

}
