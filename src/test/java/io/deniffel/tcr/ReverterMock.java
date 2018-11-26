package io.deniffel.tcr;

public class ReverterMock implements Reverter {
    public boolean wasTriggered = false;

    @Override
    public void revert() {
        this.wasTriggered = true;
    }
}
