package pento.model;

public class Statement {

    private long id = -1L;

    private int generation;

    private boolean deleted;

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

    public Statement(Statement s) {
        this(s.subject, s.predicate, s.object, System.currentTimeMillis(), s.origin);
        this.id = s.id;
        this.generation = s.generation;
    }

    public Statement mutate(Object object) {
        if (this.deleted) throw new RuntimeException("You can not mutate a deleted statement");
        if (this.id < 0) throw new RuntimeException("You can not mutate a statement which has not been saved");
        Statement s = new Statement(this);
        s.object = object;
        this.deleted = true;
        return s;
    }

    public void delete() {
        this.deleted = true;
    }

    public long getId() {
        return id;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean isDeleted() {
        return deleted;
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
                "id=" + id +
                ", generation=" + generation +
                ", deleted=" + deleted +
                ", subject='" + subject + '\'' +
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

        if (deleted != statement.deleted) return false;
        if (generation != statement.generation) return false;
        if (id != statement.id) return false;
        if (!object.equals(statement.object)) return false;
        if (!origin.equals(statement.origin)) return false;
        if (!predicate.equals(statement.predicate)) return false;
        if (!subject.equals(statement.subject)) return false;
        if (!timestamp.equals(statement.timestamp)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + generation;
        result = 31 * result + (deleted ? 1 : 0);
        result = 31 * result + subject.hashCode();
        result = 31 * result + predicate.hashCode();
        result = 31 * result + object.hashCode();
        result = 31 * result + timestamp.hashCode();
        result = 31 * result + origin.hashCode();
        return result;
    }
}
