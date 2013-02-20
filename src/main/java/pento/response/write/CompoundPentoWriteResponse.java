package pento.response.write;

import pento.model.Confidence;
import pento.model.Pento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A composition of PentoWriteResponse instances. All PentoWriteResponse methods return the first
 * PentoRespmse maintained by the composite, Access to all responses is available via the response List
 */
public class CompoundPentoWriteResponse implements PentoWriteResponse {

    List<PentoWriteResponse> responses = new ArrayList<PentoWriteResponse>();

    public CompoundPentoWriteResponse() {
    }

    @Override
    public String getOrigin() {
        return responses.get(0).getOrigin();
    }

    @Override
    public Object getBody() {
        return responses.get(0).getBody();
    }

    @Override
    public Pento getPento() {
        return responses.get(0).getPento();
    }

    @Override
    public Confidence getConfidence() {
        return responses.get(0).getConfidence();
    }

    public Collection<PentoWriteResponse> getResponses() {
        return responses;
    }

    public void add(PentoWriteResponse response){
        responses.add(response);
    }

}
