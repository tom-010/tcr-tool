package io.deniffel.tcr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TcrCoreIdeaTests {

    private Tcr tcr;
    private BuilderMock builder;
    private TesterMock tester;
    private CommiterMock commiter;

    @Before
    public void setUp() {
        commiter = new CommiterMock();
        tester = new TesterMock();
        builder = new BuilderMock();
        tcr = createTcr();
    }

    Tcr createTcr() {
        return new Tcr(builder, tester, commiter);
    }

    @Test
    public void tcrStartsWithBuild() {
        tcr.execute();
        assertTrue(builder.buildWasTriggered);
    }

    @Test
    public void buildWasSuccessful_testsAreExecuted() {
        builder.nextResult = true;
        tcr.execute();
        assertTrue(tester.commitWasTriggered);
    }

    @Test
    public void buildWasNotSuccessful_toTestsAreExecuted() {
        builder.nextResult = false;
        tcr.execute();
        assertFalse(tester.commitWasTriggered);
    }

    @Test
    public void testsWhereSuccessful_commit() {
        builder.nextResult = true;
        tester.nextResult = true;

        tcr.execute();

        assertTrue(commiter.wasTriggered);

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

    public static class TesterMock implements Tester {
        public boolean commitWasTriggered = false;
        public boolean nextResult;

        @Override
        public boolean test() {
            commitWasTriggered = true;
            return true;
        }
    }

    public static class CommiterMock implements Commiter {
        public boolean wasTriggered = false;

        @Override
        public void commit() {
            wasTriggered = true;
        }
    }

}
