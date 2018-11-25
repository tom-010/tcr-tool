package io.deniffel.tcr;

import org.junit.Test;

public class TcrCoreIdeaTests {

    @Test
    public void tcrStartsWithBuild() {

        Tcr tcr = new Tcr();
        tcr.execute();

    }
}
