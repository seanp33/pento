package pento.response;

import pento.model.Confidence;
import pento.model.Pento;

public class FailedPentoResponse implements PentoResponse {

    private Pento pento;

    private Throwable cause;

    private String origin;

    public FailedPentoResponse(Pento pento, Throwable cause) {
        this.pento = pento;
        this.cause = cause;
    }

    public FailedPentoResponse(Pento pento, Throwable cause, String origin) {
        this.pento = pento;
        this.cause = cause;
        this.origin = origin;
    }

    @Override
    public Confidence getConfidence() {
        return Confidence.NONE;
    }

    @Override
    public Pento getPento() {
        return pento;
    }

    public Throwable getCause() {
        return cause;
    }

    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public String getOrigin() {
        return origin;
    }
}
