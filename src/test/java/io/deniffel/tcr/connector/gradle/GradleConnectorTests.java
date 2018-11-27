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
    public void setUp() {
        gradle = new GradleMock();
        gradleConnector = new GradleConnector(gradle);
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
        gradleConnector.build();
        assertTrue(gradle.buildWasTriggered);
    }

    @Test
    public void testTriggersGradle() {
        gradleConnector.test();
        assertTrue(gradle.testWasTriggered);
    }
}
