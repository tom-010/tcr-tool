package io.deniffel.tcr;

public class Tcr {

    Builder builder;

    public Tcr(Builder builder) {
        this.builder = builder;
    }

    public void execute() {
        builder.build();
    }
}
