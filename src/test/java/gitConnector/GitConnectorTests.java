package gitConnector;

import io.deniffel.tcr.core.Commiter;
import io.deniffel.tcr.core.Reverter;
import io.deniffel.tcr.gitConnector.GitConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GitConnectorTests {

    GitConnector gitConnector;

    @Before
    public void setUp() throws Exception {
        gitConnector = new GitConnector();
    }

    @Test
    public void instanceOfCommiter() {
        assertTrue(gitConnector instanceof Commiter);
    }

    @Test
    public void instanceOfReverter() {
        assertTrue(gitConnector instanceof Reverter);
    }
}
