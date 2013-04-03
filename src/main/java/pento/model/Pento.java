package pento.model;

import java.util.Collection;

public final class Pento {

    private Collection<Statement> statements;

    public Pento() {
    }

    public Pento(Collection<Statement> statements) {
        this.statements = statements;
    }

    public Collection<Statement> getStatements() {
        return statements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pento pento = (Pento) o;

        if (statements != null ? !statements.equals(pento.statements) : pento.statements != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return statements != null ? statements.hashCode() : 0;
    }
}
