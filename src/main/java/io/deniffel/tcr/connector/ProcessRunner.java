package io.deniffel.tcr.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessRunner {
    public boolean execute(String... command) {
        try {
            doExecute(command);
            return true;
        } catch (IOException err) {
            err.printStackTrace();
            return false;
        }
    }

    private int doExecute(String[] command) throws IOException {
        Process p = Runtime.getRuntime().exec(command);
        String result = readProcessOutput(p);
        System.out.println(result);
        return p.exitValue();
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
}
