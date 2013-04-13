package pento.response;

import pento.model.Confidence;

/**
 * @deprecated
 *
 * @see pento.handler.PentoCallback
 */
public interface Response {

    Confidence getConfidence();

    String getOrigin();
}
