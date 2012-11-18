package pento.model;

public class Statement {

    private final String subject;

    private final String predicate;

    private final Object object;

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
}
