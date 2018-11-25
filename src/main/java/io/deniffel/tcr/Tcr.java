package io.deniffel.tcr;

public class Tcr {

    Builder builder;
    Commiter commiter;

    public Tcr(Builder builder, Commiter commiter) {
        this.builder = builder;
        this.commiter = commiter;
    }

    public void execute() {
        builder.build();
        commiter.commit();
    }
}
