package pento.store.mock;

import pento.model.Confidence;
import pento.store.PentoResponse;

public class MockPentoResponse implements PentoResponse{
    @Override
    public Confidence getConfidence() {
        return Confidence.LOCAL;
    }
}
