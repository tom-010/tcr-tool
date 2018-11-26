package gitConnector;

import io.deniffel.tcr.gitConnector.Git;

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
