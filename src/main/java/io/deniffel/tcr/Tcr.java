package io.deniffel.tcr;

public class Tcr {

    private Commiter commiter;
    private Builder builder;
    private Tester tester;

    public Tcr(Builder builder, Tester tester, Commiter commiter) {
        this.builder = builder;
        this.tester = tester;
        this.commiter = commiter;
    }

    public void execute() {
        if(!builder.build())
            return;

        if(tester.test())
            commiter.commit();
    }
}
