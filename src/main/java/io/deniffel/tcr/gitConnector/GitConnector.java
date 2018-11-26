package io.deniffel.tcr.gitConnector;

import io.deniffel.tcr.core.Commiter;
import io.deniffel.tcr.core.Reverter;

public class GitConnector implements Commiter, Reverter {

    private Git git;

    public GitConnector(Git git) {
        this.git = git;
    }

    @Override
    public void commit() {

    }

    @Override
    public void revert() {

    }
}
