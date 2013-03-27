package pento.response.read;

import pento.model.Pento;
import pento.op.PentoQuery;

public class SinglePentoReadResponse implements PentoReadResponse {

    private PentoQuery pentoQuery;

    private Iterable<Pento> penti;

    private String origin;

    public SinglePentoReadResponse() {
    }

    public SinglePentoReadResponse(Iterable<Pento> penti, PentoQuery pentoQuery, String origin) {
        this.penti = penti;
        this.pentoQuery = pentoQuery;
        this.origin = origin;
    }

    @Override
    public PentoQuery getPentoQuery() {
        return pentoQuery;
    }

    public void setPentoQuery(PentoQuery pentoQuery) {
        this.pentoQuery = pentoQuery;
    }

    @Override
    public Iterable<Pento> getPenti() {
        return penti;
    }

    public void setPenti(Iterable<Pento> penti) {
        this.penti = penti;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}