package pento.store.mock;

import pento.model.Confidence;
import pento.model.Pento;

public class MockPentoWriteResponse {

    private Pento pento;

    public MockPentoWriteResponse(Pento pento) {
        this.pento = pento;
    }

    public Confidence getConfidence() {
        return Confidence.LOCAL;
    }

    public Pento getPento() {
        return pento;
    }

    public String getOrigin() {
        return "mock";
    }
}
