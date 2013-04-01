package pento.model;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PentoTest {

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
        statements.add(s1.mutate("GFC"));

        assertThat(statements.size(), is(4));
        it = statements.iterator();
        s1 = it.next();
        assertThat(s1.isDeleted(), is(true));

        it.next();
        it.next();
        Statement s1b = it.next();
        assertEquals("GFC", s1b.getObject());

    }
}
