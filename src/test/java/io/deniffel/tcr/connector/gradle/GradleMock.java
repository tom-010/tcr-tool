package io.deniffel.tcr.connector.gradle;

public class GradleMock extends Gradle {
    public boolean buildWasTriggered = false;
    public boolean testWasTriggered = true;

    @Override
    public boolean build() {
        buildWasTriggered = true;
        return true;
    }

    @Override
    public boolean test() {
        testWasTriggered = true;
        return true;
    }
}