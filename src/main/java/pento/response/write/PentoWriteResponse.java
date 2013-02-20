package pento.response.write;

import pento.model.Confidence;
import pento.model.Pento;

public interface PentoWriteResponse {

    Confidence getConfidence();

    Pento getPento();

    Object getBody();

    String getOrigin();

}
