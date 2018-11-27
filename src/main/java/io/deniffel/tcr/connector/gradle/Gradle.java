package io.deniffel.tcr.connector.gradle;

import io.deniffel.tcr.connector.ProcessRunner;

public class Gradle {

    ProcessRunner process = new ProcessRunner();

    public boolean build() {
        return process.execute("gradlew", "build");
    }

    public boolean test() {
        return process.execute("gradlew", "test");
    }
}
