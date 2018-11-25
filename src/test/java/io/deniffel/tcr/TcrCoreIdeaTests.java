package io.deniffel.tcr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TcrCoreIdeaTests {

    private Tcr tcr;
    private BuilderMock builder;
    private CommiterMock commiter;

    @Before
    public void setUp() {
        commiter = new CommiterMock();
        builder = new BuilderMock();
        tcr = createTcr();
    }

    Tcr createTcr() {
        return new Tcr(builder);
    }

    @Test
    public void tcrStartsWithBuild() {
        tcr.execute();
        assertTrue(builder.buildWasTriggered);
    }

    @Test
    public void ifBuildWasSuccessful_commit() {
        builder.nextResult = true;
        tcr.execute();
        assertTrue(commiter.commitWasTriggered);
    }

    @Ignore
    @Test
    public void ifBuildWasNotSuccessful_noCommit() {
        builder.nextResult = false;
        tcr.execute();
        assertFalse(commiter.commitWasTriggered);
    }


    public static class BuilderMock implements Builder {
        public boolean buildWasTriggered = false;
        public boolean nextResult = false;

        @Override
        public boolean build() {
            buildWasTriggered = true;
            return nextResult;
        }
    }

    public static class CommiterMock implements Commiter {
        public boolean commitWasTriggered = true;

        void commit() {
            commitWasTriggered = true;
        }
    }
}
