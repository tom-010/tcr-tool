package io.deniffel.tcr.strategies;

import io.deniffel.tcr.core.Builder;
import io.deniffel.tcr.core.Commiter;
import io.deniffel.tcr.core.Reverter;
import io.deniffel.tcr.core.Tcr;
import io.deniffel.tcr.core.Tester;

public class ClassicTcr implements Tcr {

    private Builder builder;
    private Tester tester;
    private Commiter commiter;
    private Reverter reverter;

    public ClassicTcr(Builder builder, Tester tester, Commiter commiter, Reverter reverter) {
        this.builder = builder;
        this.tester = tester;
        this.commiter = commiter;
        this.reverter = reverter;
    }

    @Override
    public void execute() {
        if(!builder.build())
            return;

        if(tester.test())
            commiter.commit();
        else
            reverter.revert();
    }
}
