package io.deniffel.tcr.core;

public class ReverterMock implements Reverter {
    public boolean wasTriggered = false;

    @Override
    public void revert() {
        this.wasTriggered = true;
    }
}
