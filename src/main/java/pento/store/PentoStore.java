package pento.store;

import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Distribution;
import pento.model.Pento;
import pento.op.PentoQuery;

/**
 * Defines the storage and query interface for {@link Pento} instances. The behavior of the store, specifically the
 * terms by which {@link PentoReadHandler} and {@link PentoWriteHandler} are informed of storage store operations
 * are implementation specific.
 */
public interface PentoStore {

    void write(Pento pento, Distribution distribution, PentoWriteHandler handler, OperationContext operationContext);

    void read(PentoQuery query, Distribution distribution, PentoReadHandler handler, OperationContext operationContext);

    void close() throws Exception;
}
