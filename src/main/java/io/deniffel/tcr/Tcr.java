package io.deniffel.tcr;

public class Tcr {

    private final Reverter reverter;
    private Commiter commiter;
    private Builder builder;
    private Tester tester;

    public Tcr(Builder builder, Tester tester, Commiter commiter, Reverter reverter) {
        this.builder = builder;
        this.tester = tester;
        this.commiter = commiter;
        this.reverter = reverter;
    }

    public void execute() {
        if(!builder.build())
            return;

        if(tester.test())
            commiter.commit();
    }
}
