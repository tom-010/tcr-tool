package io.deniffel.tcr.connector.gradle;

import io.deniffel.tcr.core.Builder;
import io.deniffel.tcr.core.Tester;

public class GradleConnector implements Builder, Tester {

    public GradleConnector(Gradle gradle) {

    }

    @Override
    public boolean build() {
        return false;
    }

    @Override
    public boolean test() {
        return false;
    }
}
