package org.example.petclinic.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import org.archunit.shared.SharedArchitectureTest;

@AnalyzeClasses(packages = "org.example.petclinic", importOptions = {ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeTests.class})
public class Test {

   // @ArchTest
   // public static final ArchTests naming_rules = ArchTests.in(SharedArchitectureTest.class);



}
