package io.deniffel.tcr;

import io.deniffel.tcr.connector.git.Git;
import io.deniffel.tcr.connector.git.GitConnector;
import io.deniffel.tcr.connector.gradle.Gradle;
import io.deniffel.tcr.connector.gradle.GradleConnector;
import io.deniffel.tcr.strategies.ClassicTcr;

public class Application {

    public static void main(String... args) {

        GradleConnector gradle = new GradleConnector(new Gradle());
        GitConnector git = new GitConnector(new Git());

        ClassicTcr tcr = new ClassicTcr();

    }
}
