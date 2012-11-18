package pento.store.mock;

import pento.model.Confidence;
import pento.model.Pento;
import pento.response.PentoResponse;

public class MockPentoResponse implements PentoResponse {

    private Pento pento;

    public MockPentoResponse(Pento pento) {
        this.pento = pento;
    }

    @Override
    public Confidence getConfidence() {
        return Confidence.LOCAL;
    }

    @Override
    public Pento getPento() {
        return pento;
    }

}
