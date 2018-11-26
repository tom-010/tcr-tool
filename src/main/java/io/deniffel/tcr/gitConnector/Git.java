package io.deniffel.tcr.gitConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Git {


    public void commit() {
        execute("git", "commit", "-am", "working");
    }

    private void execute(String... command) {
        try {
            doExecute(command);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    private void doExecute(String[] command) throws IOException {
        Process p = Runtime.getRuntime().exec(command);
        String result = readProcessOutput(p);
        System.out.println(result);
    }

    private String readProcessOutput(Process p) throws IOException {
        String result = "";
        try(BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;

            while ((line = input.readLine()) != null) {
                result += line + "\n";
            }
        }
        return result;
    }


    public static void main(String... args) {
        new Git().commit();
    }

    public void reset() {

    }

}
