package pento.handler;


import pento.store.PentoResponse;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoWriteHandler<Pento> extends PentoHandler {

    public void success(Pento pento, PentoResponse response);

    public void error(Pento pento, PentoResponse response);
}
