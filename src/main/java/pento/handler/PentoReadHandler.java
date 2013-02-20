package pento.handler;

import pento.op.PentoQuery;
import pento.response.write.PentoWriteResponse;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoReadHandler<Iterator> extends PentoHandler {

    void success(Iterator penti, PentoWriteResponse response, PentoQuery query);

    void error(PentoWriteResponse response, PentoQuery query);
}
