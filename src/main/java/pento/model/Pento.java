package pento.model;

public final class Pento {

    private final Statement statement;

    private final Long timestamp;

    private final String origin;

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

    @Override
    public String toString() {
        return "Pento{" +
                "statement=" + statement +
                ", timestamp=" + timestamp +
                ", origin='" + origin + '\'' +
                '}';
    }
}
