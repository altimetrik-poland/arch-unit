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
            .adapter("persistence", "org.example.user.framework.adapters.output.springdata")
            .adapter("rest", "org.example.user.framework.adapters.input.rest")
            .adapter("cli", "org.example.user.framework.adapters.input.stdin");






    /*
    @ArchTest
    public static final ArchRule adaptersShouldBePackagePrivate =
            classes()
                    .that()
                    .resideInAPackage("..org.example.user.framework..")
                    .should()
                    .bePackagePrivate();


    @ArchTest
    public static final ArchRule domainShouldBeIndependent =
            classes()
                    .that()
                    .resideInAPackage("..core..")
                    .should()
                    .onlyDependOnClassesThat()
                    .resideInAnyPackage("..core..", "java..");

*/
}
