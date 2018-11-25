package io.deniffel.tcr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TcrCoreIdeaTests {


    BuilderMock builder;

    @Before
    public void setUp() throws Exception {
        builder = new BuilderMock();
    }

    Tcr createTcr() {
        return new Tcr();
    }

    @Test
    public void tcrStartsWithBuild() {
        Tcr tcr = createTcr();
        tcr.execute();
        Assert.assertTrue(builder.buildWasTriggered);
    }

    public static class BuilderMock implements Builder {
        public boolean buildWasTriggered = true;
    }
}
