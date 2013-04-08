package pento.model;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

public class ModelTestUtils {

    public static void fakeSave(Pento pento) throws Exception {
        for (Statement s : pento.getStatements()) {
            fakeSave(s);
        }
    }

    public static int[] fakeSave(Statement statement) throws Exception {
        int idVal = Integer.parseInt(randomNumeric(3));
        Field id = Statement.class.getDeclaredField("id");
        id.setAccessible(true);
        id.setInt(statement, idVal);

        int genVal = Integer.parseInt(randomNumeric(1));
        Field generation = Statement.class.getDeclaredField("generation");
        generation.setAccessible(true);
        Map<String, Integer> genMap = new LinkedHashMap<String, Integer>();
        genMap.put(statement.getOrigin(), 1);
        generation.set(statement, genMap);

        return new int[]{idVal, genVal};
    }

    public static Statement newSampleStatement() {
        return new Statement("foaf:Person#1", "foaf:geekcode", "GFA", System.currentTimeMillis(), "TEST");
    }

    public static Statement newRandomStatement() {
            return new Statement("test:"+randomAlphanumeric(3), "test:" + randomAlphanumeric(3), randomAlphanumeric(3), System.currentTimeMillis(), "TEST");
        }
}
