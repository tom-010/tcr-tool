package gitConnector;

import io.deniffel.tcr.core.Commiter;
import io.deniffel.tcr.gitConnector.GitConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GitConnectorTests {

    GitConnector gitConnector;

    @Before
    public void setUp() throws Exception {
        gitConnector = new GitConnector();
    }

    @Test
    public void instanceOfCommiter() {
        Assert.assertTrue(gitConnector instanceof Commiter);
    }
}
