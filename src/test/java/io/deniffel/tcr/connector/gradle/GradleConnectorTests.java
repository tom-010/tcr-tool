package io.deniffel.tcr.connector.gradle;

import io.deniffel.tcr.core.Builder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GradleConnectorTests {

    GradleConnector gradleConnector;

    @Before
    public void setUp() throws Exception {
        gradleConnector = new GradleConnector();
    }

    @Test
    public void instanceOfBuilder() {
        assertTrue(gradleConnector instanceof Builder);
    }
}
