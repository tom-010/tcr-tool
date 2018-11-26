package io.deniffel.tcr;

public class Tcr {

    Builder builder;
    Tester tester;

    public Tcr(Builder builder, Tester tester) {
        this.builder = builder;
        this.tester = tester;
    }

    public void execute() {
        if(builder.build())
            tester.test();
    }
}
