package pento.store;

import pento.handler.PentoCallback;
import pento.model.Distribution;
import pento.model.Pento;
import pento.op.PentoQuery;

/**
 * Defines the storage and query interface for {@link Pento} instances. The behavior of the store, specifically the
 * terms by which read {@link PentoCallback} and write {@link PentoCallback} are informed of storage operations
 * are implementation specific.
 */
public interface PentoStore {

    void write(Pento pento, Distribution distribution, PentoCallback handler, OperationContext operationContext);

    void read(PentoQuery query, Distribution distribution, PentoCallback handler, OperationContext operationContext);

    void close() throws Exception;
}
