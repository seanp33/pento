package pento.response;

import pento.model.Confidence;

public interface Response {

    Confidence getConfidence();

    String getOrigin();
}
