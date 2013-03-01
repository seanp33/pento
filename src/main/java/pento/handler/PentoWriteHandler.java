package pento.handler;


import pento.response.write.FailedPentoWriteResponse;
import pento.response.write.PentoWriteResponse;

/**
 *
 */
public interface PentoWriteHandler {

    public void success(PentoWriteResponse response);

    public void failure(FailedPentoWriteResponse response);
}
