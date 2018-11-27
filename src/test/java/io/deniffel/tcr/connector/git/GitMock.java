package io.deniffel.tcr.connector.git;

public class GitMock extends Git {

    public boolean commitWasTriggered = false;
    public boolean resetWasTriggered = false;

    @Override
    public void commit() {
        commitWasTriggered = true;
    }

    @Override
    public void reset() {
        resetWasTriggered = true;
    }
}
