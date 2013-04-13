package pento.response.read;

import pento.model.Confidence;
import pento.model.Pento;
import pento.op.PentoQuery;

/**
 * @see pento.handler.PentoCallback
 * @deprecated
 */
public class SuccessfulPentoReadResponse extends PentoReadResponse {

    private PentoQuery pentoQuery;

    private Iterable<Pento> penti;

    private String origin;

    private Confidence confidence;

    public SuccessfulPentoReadResponse() {
    }

    public SuccessfulPentoReadResponse(Iterable<Pento> penti, PentoQuery pentoQuery, Confidence confidence, String origin) {
        this.penti = penti;
        this.pentoQuery = pentoQuery;
        this.confidence = confidence;
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

    @Override
    public Confidence getConfidence() {
        return confidence;
    }

    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }
}