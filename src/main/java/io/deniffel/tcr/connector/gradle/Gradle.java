package io.deniffel.tcr.connector.gradle;

import io.deniffel.tcr.connector.ProcessRunner;

public class Gradle {

    ProcessRunner process = new ProcessRunner();

    public boolean build() {
        return true;
    }

    public boolean test() {
        return true;
    }
}
