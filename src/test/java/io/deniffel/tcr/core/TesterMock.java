package io.deniffel.tcr.core;

public class TesterMock implements Tester {
    public boolean commitWasTriggered = false;
    public boolean nextResult = false;

    @Override
    public boolean test() {
        commitWasTriggered = true;
        return nextResult;
    }
}
