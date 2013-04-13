package pento.handler;


import pento.response.write.FailedPentoWriteResponse;
import pento.response.write.PentoWriteResponse;

/**
 * @see PentoCallback
 * @deprecated
 */
public interface PentoWriteHandler {

    public void success(PentoWriteResponse response);

    public void failure(FailedPentoWriteResponse response);
}
