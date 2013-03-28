package pento.store.mock;

import pento.model.Confidence;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.read.PentoReadResponse;

import java.util.Collections;

public class MockPentoReadResponse implements PentoReadResponse {

    private PentoQuery query;

    public MockPentoReadResponse(PentoQuery query) {
        this.query = query;
    }

    @Override
    public Iterable<Pento> getPenti() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public PentoQuery getPentoQuery() {
        return query;
    }

    @Override
    public Confidence getConfidence() {
        return Confidence.LOCAL;
    }

    @Override
    public String getOrigin() {
        return "mock";
    }
}
