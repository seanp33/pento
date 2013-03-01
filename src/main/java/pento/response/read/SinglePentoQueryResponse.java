package pento.response.read;

import pento.model.Pento;
import pento.op.PentoQuery;

public class SinglePentoQueryResponse implements PentoReadResponse {

    private PentoQuery pentoQuery;

    private Iterable<Pento> penti;

    private String origin;

    public SinglePentoQueryResponse(Iterable<Pento> penti, PentoQuery pentoQuery, String origin) {
        this.penti = penti;
        this.pentoQuery = pentoQuery;
        this.origin = origin;
    }

    @Override
    public Iterable<Pento> getPenti() {
        return penti;
    }

    @Override
    public PentoQuery getPentoQuery() {
        return pentoQuery;
    }

    @Override
    public String getOrigin() {
        return origin;
    }
}