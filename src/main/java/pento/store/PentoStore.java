package pento.store;

import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.op.PentoQuery;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 8:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoStore {

    void write(Pento pento, PentoWriteHandler handler);

    void read(PentoQuery query, PentoReadHandler handler);

    void close() throws Exception;
}
