package pento.model;

public class Statement {

    private String subject;

    private String predicate;

    private Object object;

    private Long timestamp;

    private String origin;

    public Statement() {
    }

    public Statement(String subject, String predicate, Object object, Long timestamp, String origin) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
        this.timestamp = timestamp;
        this.origin = origin;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "subject='" + subject + '\'' +
                ", predicate='" + predicate + '\'' +
                ", object=" + object +
                ", timestamp=" + timestamp +
                ", origin='" + origin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statement statement = (Statement) o;

        if (object != null ? !object.equals(statement.object) : statement.object != null) return false;
        if (origin != null ? !origin.equals(statement.origin) : statement.origin != null) return false;
        if (predicate != null ? !predicate.equals(statement.predicate) : statement.predicate != null) return false;
        if (subject != null ? !subject.equals(statement.subject) : statement.subject != null) return false;
        if (timestamp != null ? !timestamp.equals(statement.timestamp) : statement.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (predicate != null ? predicate.hashCode() : 0);
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        return result;
    }
}
