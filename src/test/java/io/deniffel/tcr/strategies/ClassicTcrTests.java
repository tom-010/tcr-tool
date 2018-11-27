package io.deniffel.tcr.strategies;

import io.deniffel.tcr.core.BuilderMock;
import io.deniffel.tcr.core.CommiterMock;
import io.deniffel.tcr.core.ReverterMock;
import io.deniffel.tcr.core.TesterMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassicTcrTests {

    private ClassicTcr tcr;
    private BuilderMock builder;
    private TesterMock tester;
    private CommiterMock commiter;
    private ReverterMock reverter;

    @Before
    public void setUp() {
        reverter = new ReverterMock();
        commiter = new CommiterMock();
        tester = new TesterMock();
        builder = new BuilderMock();
        tcr = new ClassicTcr(builder, tester, commiter, reverter);

        builder.nextResult = true;
    }

    @Test
    public void tcrStartsWithBuild() {
        tcr.execute();
        assertTrue(builder.buildWasTriggered);
    }

    @Test
    public void buildWasSuccessful_testsAreExecuted() {
        builder.nextResult = true;
        tcr.execute();
        assertTrue(tester.commitWasTriggered);
    }

    @Test
    public void buildWasNotSuccessful_toTestsAreExecuted() {
        builder.nextResult = false;
        tcr.execute();
        assertFalse(tester.commitWasTriggered);
    }

    @Test
    public void testsWhereSuccessful_commit() {
        tester.nextResult = true;
        tcr.execute();
        assertTrue(commiter.wasTriggered);
    }

    @Test
    public void testFailed_revert() {
        tester.nextResult = false;
        tcr.execute();
        assertTrue(reverter.wasTriggered);
    }

    // ----

    @Test
    public void testFailed_noCommit() {
        tester.nextResult = false;
        tcr.execute();
        assertFalse(commiter.wasTriggered);
    }

    @Test
    public void testSuccessful_noRevert() {
        tester.nextResult = true;
        tcr.execute();
        assertFalse(reverter.wasTriggered);
    }
}
