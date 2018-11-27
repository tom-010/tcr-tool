package io.deniffel.tcr.connector.gradle;

import io.deniffel.tcr.core.Builder;
import io.deniffel.tcr.core.Tester;

public class GradleConnector implements Builder, Tester {

    private Gradle gradle;

    public GradleConnector(Gradle gradle) {
        this.gradle = gradle;
    }

    @Override
    public boolean build() {
        return gradle.build();
    }

    @Override
    public boolean test() {
        return gradle.test();
    }
}
