package pento.response.write;

import pento.model.Confidence;
import pento.model.Pento;

/**
 * @deprecated
 *
 * @see pento.handler.PentoCallback
 */
public class SinglePentoWriteResponse implements PentoWriteResponse {

    private Pento pento;

    private Confidence confidence;

    private Object body;

    private String origin;

    public SinglePentoWriteResponse() {
    }

    public SinglePentoWriteResponse(Pento pento, Confidence confidence, String origin) {
        this.pento = pento;
        this.confidence = confidence;
        this.origin = origin;
    }

    public Pento getPento() {
        return pento;
    }

    public void setPento(Pento pento) {
        this.pento = pento;
    }

    public Confidence getConfidence() {
        return confidence;
    }

    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
