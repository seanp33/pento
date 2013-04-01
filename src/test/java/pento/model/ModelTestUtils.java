package pento.model;

import java.lang.reflect.Field;

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
        generation.setInt(statement, genVal);

        return new int[]{idVal, genVal};
    }
}
