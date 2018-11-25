package io.deniffel.tcr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TcrCoreIdeaTests {

    private Tcr tcr;
    private BuilderMock builder;

    @Before
    public void setUp() {
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

    }

    public static class BuilderMock implements Builder {
        public boolean buildWasTriggered = false;
        public boolean nextResult = false;

        @Override
        public boolean build() {
            buildWasTriggered = true;
            return true;
        }
    }
}
