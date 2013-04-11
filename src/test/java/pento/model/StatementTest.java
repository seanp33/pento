package pento.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static pento.model.ModelTestUtils.newSampleStatement;

public class StatementTest {

    @Test
    public void testConstruction() {
        Statement s1 = newSampleStatement();
        assertThat(s1.getId(), is(-1L));
        assertThat(s1.getGeneration().get(s1.getOrigin()), is(0));
        assertThat(s1.getSubject(), is("foaf:Person#1"));
        assertThat(s1.getPredicate(), is("foaf:geekcode"));
        assertEquals("GFA", s1.getObject());
        assertThat(s1.getOrigin(), is("TEST"));
        assertThat(s1.getTimestamp(), notNullValue());
        assertThat(s1.getCommand(), is(Command.ASSERT));
    }

    @Test
    public void testMutate() throws Exception {
        Statement s1 = newSampleStatement();

        // sleep to offset timestamp
        Thread.sleep(200);

        int[] fakeVals = ModelTestUtils.fakeSave(s1);
        s1.update("GCS");

        assertThat(s1.getCommand(), is(Command.UPDATE));
        assertEquals(fakeVals[0], s1.getId());
        assertThat(s1.getGeneration().get(s1.getOrigin()), is(1));
        assertThat(s1.getSubject(), is("foaf:Person#1"));
        assertThat(s1.getPredicate(), is("foaf:geekcode"));
        assertEquals("GCS", s1.getObject());
        assertThat(s1.getOrigin(), is("TEST"));
    }

    @Test(expected = RuntimeException.class)
    public void testIllegalMutateCasedByNoId() {
        Statement s1 = newSampleStatement();
        s1.update("illegal");
    }
}
