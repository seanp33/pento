package pento.response;

import pento.model.Confidence;
import pento.model.Pento;

public class FailedPentoResponse implements PentoResponse {

    private Pento pento;

    public FailedPentoResponse(Pento pento) {
        this.pento = pento;
    }

    @Override
    public Confidence getConfidence() {
        return Confidence.NONE;
    }

    @Override
    public Pento getPento() {
        return pento;
    }
}
