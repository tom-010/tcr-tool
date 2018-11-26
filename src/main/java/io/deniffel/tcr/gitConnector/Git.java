package io.deniffel.tcr.gitConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Git {

    private ProcessRunner process = new ProcessRunner();

    public void commit() {
        process.execute("git", "commit", "-am", "working");
    }



    public static void main(String... args) {
        new Git().commit();
    }

    public void reset() {

    }

}
