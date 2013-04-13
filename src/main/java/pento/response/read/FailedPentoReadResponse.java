package pento.response.read;

import pento.model.Confidence;
import pento.model.Pento;
import pento.op.PentoQuery;

/**
 * Provides the details of a failed Pento read operation. In the case of a complete error it is possible that
 * the implementation of {@link pento.response.read.PentoReadResponse#getPenti()} will return null or an empty
 * {@link Iterable<Pento>}
 *
 * @see pento.handler.PentoCallback
 * @deprecated
 */
public class FailedPentoReadResponse extends PentoReadResponse {

    private PentoQuery pentoQuery;

    private Iterable<Pento> penti;

    private String origin;

    private Throwable cause;

    public FailedPentoReadResponse(PentoQuery pentoQuery, Iterable<Pento> penti, String origin, Throwable cause) {
        this.pentoQuery = pentoQuery;
        this.penti = penti;
        this.origin = origin;
        this.cause = cause;
    }

    public FailedPentoReadResponse(PentoQuery pentoQuery, String origin, Throwable cause) {
        this.pentoQuery = pentoQuery;
        this.origin = origin;
        this.cause = cause;
    }

    public FailedPentoReadResponse(PentoQuery pentoQuery, Throwable cause) {
        this.pentoQuery = pentoQuery;
        this.cause = cause;
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
    public Confidence getConfidence() {
        return Confidence.NONE;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    public Throwable getCause() {
        return cause;
    }
}
