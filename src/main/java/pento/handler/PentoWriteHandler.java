package pento.handler;


import pento.response.write.FailedPentoWriteResponse;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoWriteHandler<PentoResponse> extends PentoHandler {

    public void success(PentoResponse response);

    public void failure(FailedPentoWriteResponse response);
}
