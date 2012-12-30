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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pento pento = (Pento) o;

        if (!origin.equals(pento.origin)) return false;
        if (!statements.equals(pento.statements)) return false;
        if (!timestamp.equals(pento.timestamp)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statements.hashCode();
        result = 31 * result + timestamp.hashCode();
        result = 31 * result + origin.hashCode();
        return result;
    }
}
