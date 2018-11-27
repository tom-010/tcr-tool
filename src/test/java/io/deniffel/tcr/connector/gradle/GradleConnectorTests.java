package io.deniffel.tcr.connector.gradle;

import io.deniffel.tcr.core.Builder;
import io.deniffel.tcr.core.Tester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GradleConnectorTests {

    private GradleConnector gradleConnector;
    private GradleMock gradle;


    @Before
    public void setUp() throws Exception {
        gradle = new GradleMock();
        gradleConnector = new GradleConnector();
    }

    @Test
    public void instanceOfBuilder() {
        assertTrue(gradleConnector instanceof Builder);
    }

    @Test
    public void instanceOfTester() {
        assertTrue(gradleConnector instanceof Tester);
    }

    @Test
    public void buildTriggersGradle() {

    }

    public static class GradleMock extends Gradle {

    }

}
