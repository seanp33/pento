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


}
