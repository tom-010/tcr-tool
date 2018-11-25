package io.deniffel.tcr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TcrCoreIdeaTests {


    private BuilderMock builder;

    @Before
    public void setUp() {
        builder = new BuilderMock();
    }

    Tcr createTcr() {
        return new Tcr(builder);
    }

    @Test
    public void tcrStartsWithBuild() {
        Tcr tcr = createTcr();
        tcr.execute();
        Assert.assertTrue(builder.buildWasTriggered);
    }

    public static class BuilderMock implements Builder {
        public boolean buildWasTriggered = true;

        @Override
        public void build() {
            buildWasTriggered = true;
        }
    }
}
