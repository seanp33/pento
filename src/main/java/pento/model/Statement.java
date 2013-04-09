package pento.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Statement {

    private long id = -1L;

    // order matters in pento's vclocks
    private LinkedHashMap<String, Integer> generation = new LinkedHashMap<String, Integer>();

    private Command command = Command.NONE;

    private String subject;

    private String predicate;

    private Object object;

    private Long timestamp = -1L;

    private String origin;

    public Statement() {
    }

    public Statement(String subject, String predicate, Object object, Long timestamp, String origin) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
        this.timestamp = timestamp;
        this.origin = origin;
        this.command = Command.ASSERT;
    }

    public Statement(String subject, String predicate, Object object, String origin) {
        this(subject, predicate, object, -1L, origin);
    }

    public void update(Object object) {
        if (this.command == Command.DELETE) throw new RuntimeException("You can not mutate a deleted statement");
        if (this.command == Command.ASSERT)
            throw new RuntimeException("You can not mutate a statement which has not been saved");
        this.object = object;
        this.timestamp = System.currentTimeMillis();
        this.command = Command.UPDATE;
    }

    public void delete() {
        this.command = Command.DELETE;
    }

    public long getId() {
        return id;
    }

    public LinkedHashMap<String, Integer> getGeneration() {
        return new LinkedHashMap<String, Integer>(generation);
    }

    public Command getCommand() {
        return command;
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
                ", command=" + command +
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

        if (id != statement.id) return false;
        if (command != statement.command) return false;
        if (generation != null ? !generation.equals(statement.generation) : statement.generation != null) return false;
        if (object != null ? !object.equals(statement.object) : statement.object != null) return false;
        if (origin != null ? !origin.equals(statement.origin) : statement.origin != null) return false;
        if (predicate != null ? !predicate.equals(statement.predicate) : statement.predicate != null) return false;
        if (subject != null ? !subject.equals(statement.subject) : statement.subject != null) return false;
        if (timestamp != null ? !timestamp.equals(statement.timestamp) : statement.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (generation != null ? generation.hashCode() : 0);
        result = 31 * result + (command != null ? command.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (predicate != null ? predicate.hashCode() : 0);
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        return result;
    }
}
