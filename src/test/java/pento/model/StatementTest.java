package pento.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StatementTest {

    @Test
    public void testConstruction() {
        Statement s1 = newSampleStatement();
        assertThat(s1.getId(), is(-1L));
        assertThat(s1.getGeneration(), is(0));
        assertThat(s1.getSubject(), is("foaf:Person#1"));
        assertThat(s1.getPredicate(), is("foaf:geekcode"));
        assertEquals("GFA", s1.getObject());
        assertThat(s1.getOrigin(), is("TEST"));
        assertThat(s1.getTimestamp(), notNullValue());
        assertThat(s1.isDeleted(), is(false));
    }

    @Test
    public void testCopyConstructor() throws Exception {
        Statement s1 = newSampleStatement();

        // sleep to offset timestamp
        Thread.sleep(200);

        Statement s2 = new Statement(s1);

        assertThat(s1.isDeleted(), is(false));

        assertTrue(s2.getTimestamp() > s1.getTimestamp());
        assertThat(s2.getId(), is(s1.getId()));
        assertThat(s2.getGeneration(), is(s1.getGeneration()));
        assertThat(s2.getSubject(), is(s1.getSubject()));
        assertThat(s2.getPredicate(), is(s1.getPredicate()));
        assertEquals(s2.getObject(), s1.getObject());
        assertThat(s2.getOrigin(), is("TEST"));
    }

    @Test
    public void testMutate() throws Exception {
        Statement s1 = newSampleStatement();

        // sleep to offset timestamp
        Thread.sleep(200);

        int[] fakeVals = ModelTestUtils.fakeSave(s1);
        Statement mutated = s1.mutate("GCS");

        assertThat(s1.isDeleted(), is(true));
        assertEquals(fakeVals[0], mutated.getId());
        assertEquals(fakeVals[1], mutated.getGeneration());
        assertThat(mutated.getSubject(), is("foaf:Person#1"));
        assertThat(mutated.getPredicate(), is("foaf:geekcode"));
        assertEquals("GCS", mutated.getObject());
        assertThat(mutated.getOrigin(), is("TEST"));
        assertTrue(mutated.getTimestamp() > s1.getTimestamp());
    }

    @Test(expected = RuntimeException.class)
    public void testIllegalMutateCasedByNoId() {
        Statement s1 = newSampleStatement();
        s1.mutate("illegal");
    }

    public static Statement newSampleStatement() {
        return new Statement("foaf:Person#1", "foaf:geekcode", "GFA", System.currentTimeMillis(), "TEST");
    }
}
