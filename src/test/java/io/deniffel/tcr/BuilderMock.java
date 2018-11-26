package io.deniffel.tcr;

public class BuilderMock implements Builder {
    public boolean buildWasTriggered = false;
    public boolean nextResult = false;

    @Override
    public boolean build() {
        buildWasTriggered = true;
        return nextResult;
    }
}
