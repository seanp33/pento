package pento.store;

import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Distribution;
import pento.model.Pento;
import pento.op.PentoQuery;

public interface PentoStore {

    void write(Pento pento, Distribution distribution, PentoWriteHandler handler, WriterContext writerContext);

    void read(PentoQuery query, PentoReadHandler handler);

    void close() throws Exception;
}
