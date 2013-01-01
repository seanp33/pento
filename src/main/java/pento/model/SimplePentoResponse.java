package pento.model;

import pento.response.PentoResponse;

public class SimplePentoResponse implements PentoResponse{

    private Pento pento;

    private Confidence confidence;

    private Object body;

    private String origin;

    public SimplePentoResponse(Pento pento, Confidence confidence, String origin) {
        this.pento = pento;
        this.confidence = confidence;
        this.origin = origin;
    }`

    public SimplePentoResponse(Pento pento, Confidence confidence, String origin, Object body) {
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
        return "SimplePentoResponse{" +
                ", confidence=" + confidence +
                ", body=" + body +
                ", origin='" + origin + '\'' +
                '}';
    }
}
