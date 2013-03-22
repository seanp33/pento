package pento.model;

public class Statement {

    private String subject;

    private String predicate;

    private Object object;

    public Statement() {
    }

    public Statement(String subject, String predicate, Object object) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    public String getSubject() {
        return subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "subject='" + subject + '\'' +
                ", predicate='" + predicate + '\'' +
                ", object=" + object +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        if (!object.equals(statement.object)) return false;
        if (!predicate.equals(statement.predicate)) return false;
        if (!subject.equals(statement.subject)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subject.hashCode();
        result = 31 * result + predicate.hashCode();
        result = 31 * result + object.hashCode();
        return result;
    }
}
