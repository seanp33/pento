package pento.model;

import javax.security.auth.Subject;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */
public final class Pento {

    private final Statement statement;

    private final Long timestamp;

    private String origin;

    public Pento(Statement statement, Long timestamp, String origin) {
        this.statement = statement;
        this.timestamp = timestamp;
        this.origin = origin;
    }

    public Statement getStatement() {
        return statement;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getOrigin() {
        return origin;
    }
}
