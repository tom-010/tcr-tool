package io.deniffel.tcr.connector.git;

import io.deniffel.tcr.core.Commiter;
import io.deniffel.tcr.core.Reverter;

public class GitConnector implements Commiter, Reverter {

    private Git git;

    public GitConnector(Git git) {
        this.git = git;
    }

    @Override
    public void commit() {
        git.commit();
    }

    @Override
    public void revert() {
        git.reset();
    }
}
