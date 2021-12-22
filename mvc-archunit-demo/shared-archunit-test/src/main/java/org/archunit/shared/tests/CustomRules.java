package org.archunit.shared.tests;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class CustomRules {

    public static final ArchCondition<JavaClass> notHaveFieldsAnnotatedWithDeprecated =
        new ArchCondition<JavaClass>("should not have a field annotated with @Deprecated") {
              @Override
                public void check(JavaClass item, ConditionEvents events) {
                    if (item.getAllFields().stream()
                            .anyMatch( field -> field.isAnnotatedWith(Deprecated.class))) {
                        events.add(SimpleConditionEvent.violated(item, "should not have a field annotated with @Deprecated"));
                    }
                }
            };

}
