package pento.response.write;

import pento.model.Confidence;
import pento.model.Pento;

public class SinglePentoWriteResponse implements PentoWriteResponse {

    private Pento pento;

    private Confidence confidence;

    private Object body;

    private String origin;

    public SinglePentoWriteResponse(Pento pento, Confidence confidence, String origin) {
        this.pento = pento;
        this.confidence = confidence;
        this.origin = origin;
    }

    public SinglePentoWriteResponse(Pento pento, Confidence confidence, String origin, Object body) {
        this(pento, confidence, origin);
        this.body = body;
    }

    @Override
    public Confidence getConfidence() {
        return confidence;
    }

    @Override
    public Pento getPento() {
        return pento;
    }

    @Override
    public Object getBody() {
        return body;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "SinglePentoWriteResponse{" +
                ", confidence=" + confidence +
                ", body=" + body +
                ", origin='" + origin + '\'' +
                '}';
    }
}
