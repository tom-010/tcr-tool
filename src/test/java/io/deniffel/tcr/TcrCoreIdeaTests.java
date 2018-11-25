package io.deniffel.tcr;

import org.junit.Test;

public class TcrCoreIdeaTests {


    Tcr createTcr() {
        return new Tcr();
    }

    @Test
    public void tcrStartsWithBuild() {
        Tcr tcr = createTcr();
        tcr.execute();

    }
}
