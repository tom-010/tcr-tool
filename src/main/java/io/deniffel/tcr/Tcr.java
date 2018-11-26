package io.deniffel.tcr;

public class Tcr {

    private Builder builder;
    private Tester tester;
    private Commiter commiter;
    private Reverter reverter;

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
        reverter.revert();
    }
}
