package io.deniffel.tcr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TcrCoreIdeaTests {

    private Tcr tcr;
    private BuilderMock builder;
    private TesterMock tester;

    @Before
    public void setUp() {
        tester = new TesterMock();
        builder = new BuilderMock();
        tcr = createTcr();
    }

    Tcr createTcr() {
        return new Tcr(builder, tester);
    }

    @Test
    public void tcrStartsWithBuild() {
        tcr.execute();
        assertTrue(builder.buildWasTriggered);
    }

    @Test
    public void ifBuildWasSuccessful_testsAreExecuted() {
        builder.nextResult = true;
        tcr.execute();
        assertTrue(tester.commitWasTriggered);
    }

    @Test
    public void ifBuildWasNotSuccessful_toTestsAreExecuted() {
        builder.nextResult = false;
        tcr.execute();
        assertFalse(tester.commitWasTriggered);
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

        public void test() {
            commitWasTriggered = true;
        }
    }
}
