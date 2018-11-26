package gitConnector;

import io.deniffel.tcr.core.Commiter;
import io.deniffel.tcr.core.Reverter;
import io.deniffel.tcr.gitConnector.Git;
import io.deniffel.tcr.gitConnector.GitConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GitConnectorTests {

    GitConnector gitConnector;
    GitMock git;

    @Before
    public void setUp() throws Exception {
        git = new GitMock();
        gitConnector = new GitConnector(git);
    }

    @Test
    public void instanceOfCommiter() {
        assertTrue(gitConnector instanceof Commiter);
    }

    @Test
    public void instanceOfReverter() {
        assertTrue(gitConnector instanceof Reverter);
    }

    @Test
    public void commit_triggersGitCommit() {
        gitConnector.commit();
        assertTrue(git.commitWasTriggered);
    }

    @Test
    public void revert_triggersGitReset() {
        gitConnector.revert();
        assertTrue(git.resetWasTriggered);
    }

    public static class GitMock implements Git {

        public boolean commitWasTriggered = false;
        public boolean resetWasTriggered = true;

        @Override
        public void commit() {
            commitWasTriggered = true;
        }

        public void reset() {
            resetWasTriggered = true;
        }
    }


}
