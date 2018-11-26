package io.deniffel.tcr.core;

public class CommiterMock implements Commiter {
    public boolean wasTriggered = false;

    @Override
    public void commit() {
        wasTriggered = true;
    }
}