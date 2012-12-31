package pento.model;

import pento.response.PentoResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A composition of PentoResponse instances. All PentoResponse methods return the first
 * PentoRespmse maintained by the composite, Access to all responses is available via the response List
 */
public class CompoundPentoResponse implements PentoResponse{

    List<PentoResponse> responses = new ArrayList<PentoResponse>();

    public CompoundPentoResponse() {
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

    public Collection<PentoResponse> getResponses() {
        return responses;
    }

    public void add(PentoResponse response){
        responses.add(response);
    }

}
