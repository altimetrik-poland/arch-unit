package org.archunit.shared.tests;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class SliceTest {

    @ArchTest
    public static final ArchRule sliceRule = slices()
            .matching("..petclinic.(*)..")
            .should()
            .beFreeOfCycles();
}
