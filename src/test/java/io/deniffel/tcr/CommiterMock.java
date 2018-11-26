package io.deniffel.tcr;

public class CommiterMock implements Commiter {
    public boolean wasTriggered = false;

    @Override
    public void commit() {
        wasTriggered = true;
    }
}