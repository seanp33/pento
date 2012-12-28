package pento.response;

import pento.model.Confidence;
import pento.model.Pento;

public interface PentoResponse {

    Confidence getConfidence();

    Pento getPento();

    Object getBody();

    String getOrigin();

}
