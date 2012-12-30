package pento.model;

import java.util.Collection;

public final class Pento {

    private final Collection<Statement> statements;

    private final Long timestamp;

    private final String origin;

    public Pento(Collection<Statement> statements, Long timestamp, String origin) {
        this.statements = statements;
        this.timestamp = timestamp;
        this.origin = origin;
    }

    public Collection<Statement> getStatements() {
        return statements;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Pento{" +
                "statements=" + statements +
                ", timestamp=" + timestamp +
                ", origin='" + origin + '\'' +
                '}';
    }
}
