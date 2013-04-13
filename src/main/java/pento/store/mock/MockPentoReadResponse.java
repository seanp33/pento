package pento.store.mock;

import pento.model.Confidence;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.read.PentoReadResponse;

import java.util.Collections;

public class MockPentoReadResponse {

    private PentoQuery query;

    public MockPentoReadResponse(PentoQuery query) {
        this.query = query;
    }

    public Iterable<Pento> getPenti() {
        return Collections.EMPTY_LIST;
    }

    public PentoQuery getPentoQuery() {
        return query;
    }

    public Confidence getConfidence() {
        return Confidence.LOCAL;
    }

    public String getOrigin() {
        return "mock";
    }
}
