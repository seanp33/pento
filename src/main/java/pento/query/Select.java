package pento.query;

import com.google.common.base.Joiner;

import java.text.MessageFormat;

public class Select {
    private StringBuilder sb = new StringBuilder();

    private static final String TABLE = "PENTOS";

    private String currentGroup;

    public Select(Field... fields) {
        sb.append("SELECT " + Joiner.on(",").join(fields)).append(" FROM " + TABLE);
    }

    public Select ID(OP op) {
        sb.append(Field.ID);
        sb.append(op);
        return this;
    }

    public Select Subject(OP op) {
        sb.append(Field.SUBJECT);
        sb.append(op);
        return this;
    }

    public Select Predicate(OP op) {
        sb.append(Field.PREDICATE);
        sb.append(op);
        return this;
    }

    public Select Object(OP op) {
        sb.append(Field.OBJECT);
        sb.append(op);
        return this;
    }

    public Select Created(OP op) {
        sb.append(Field.CREATED);
        sb.append(op);
        return this;
    }

    public Select Modified(OP op) {
        sb.append(Field.MODIFIED);
        sb.append(op);
        return this;
    }

    public Select Where() {
        sb.append(" WHERE ");
        return this;
    }

    public Select And() {
        sb.append(" AND ");
        return this;
    }

    public Select Or() {
        sb.append(" OR ");
        return this;
    }

    public Select B() {
        sb.append(" (");
        return this;
    }

    public Select E() {
        sb.append(") ");
        return this;
    }

    public Select Value(Object value) {
        if (currentGroup != null) {
            sb.append(MessageFormat.format(currentGroup, prepValue(value)));
            currentGroup = null;
        } else {
            sb.append(prepValue(value));
        }
        return this;
    }

    public String build() {
        return sb.toString();
    }

    private static Object prepValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }

        return value;
    }

    public enum Field {
        ALL("*"),
        ID("id"),
        SUBJECT("subject"),
        PREDICATE("predicate"),
        OBJECT("object"),
        ORIGIN("origin"),
        CREATED("created"),
        MODIFIED("modified");

        private String sql;

        private Field(String sql) {
            this.sql = sql;
        }

        @Override
        public String toString() {
            return sql;
        }
    }

    public enum OP {
        EQ(" = "),
        NEQ(" != "),
        LT(" < "),
        LTE(" <= "),
        GT(" > "),
        GTE(" >= ");

        private String sql;

        private OP(String sql) {
            this.sql = sql;
        }

        @Override
        public String toString() {
            return sql;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Select(Field.ALL)
                        .Where().B().Subject(OP.EQ).Value("urn:person#1")
                        .Or().Predicate(OP.EQ).Value("foaf:name")
                        .And().Object(OP.EQ).Value("Sean").E()
                        .And().B().Created(OP.LT).Value(9999999999999999L)
                        .And().Created(OP.GT).Value(8888888888888888L).E()
                        .build());
    }
}


