package pento.model;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Statement {
    private String subject;

    private String predicate;

    private Object object;

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
