package pento.handler;


import pento.store.PentoResponse;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoWriteHandler<PentoResponse> extends PentoHandler {

    public void success(PentoResponse response);

    public void error(PentoResponse response);
}
