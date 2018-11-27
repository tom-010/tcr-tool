package io.deniffel.tcr.gitConnector;

public class Git {

    private ProcessRunner process = new ProcessRunner();

    public void commit() {
        process.execute("git", "commit", "-am", "working");
    }

    public void reset() {
        process.execute("git", "checkout", "HEAD", "--", "src/main/");
    }

}
