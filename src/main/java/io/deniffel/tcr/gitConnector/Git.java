package io.deniffel.tcr.gitConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Git {


    public void commit() {
        execute("git", "commit", "-am", "working");
    }

    protected void execute(String... command) {
        try {
            Process p = Runtime.getRuntime().exec(command);

            try(BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;

                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void main(String... args) {
        new Git().commit();
    }

    public void reset() {

    }

}
