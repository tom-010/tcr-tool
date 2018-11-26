package io.deniffel.tcr.core;

public class BuilderMock implements Builder {
    public boolean buildWasTriggered = false;
    public boolean nextResult = false;

    @Override
    public boolean build() {
        buildWasTriggered = true;
        return nextResult;
    }
}
