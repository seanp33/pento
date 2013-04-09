package pento.model;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static pento.model.ModelTestUtils.newRandomStatement;

public class PentoTest {

    @Test
    public void testEqualsAndHashcode() {
        Statement s1 = newRandomStatement();
        Statement s2 = newRandomStatement();
        Statement s3 = newRandomStatement();
        Pento p1 = new Pento(Arrays.asList(s1, s2, s3));
        Pento p2 = new Pento(Arrays.asList(s1, s2, s3));
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testMutation() throws Exception {

        List<Statement> stmts = new ArrayList<Statement>();
        stmts.add(new Statement("foaf:Person#1", "foaf:geekcode", "GFA", System.currentTimeMillis(), "TEST"));
        stmts.add(new Statement("foaf:Person#2", "foaf:geekcode", "GFC", System.currentTimeMillis(), "TEST"));
        stmts.add(new Statement("foaf:Person#3", "foaf:geekcode", "GMU", System.currentTimeMillis(), "TEST"));

        Pento p = new Pento(stmts);
        ModelTestUtils.fakeSave(p);

        Collection<Statement> statements = p.getStatements();
        assertThat(statements.size(), is(3));

        Iterator<Statement> it = statements.iterator();
        Statement s1 = it.next();
        s1.update(("GFC"));
        assertEquals("GFC", s1.getObject());
        assertThat(s1.getCommand(), is(Command.UPDATE));
    }
}
