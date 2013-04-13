package pento.handler;

import pento.model.Pento;
import pento.response.read.FailedPentoReadResponse;
import pento.response.read.PentoReadResponse;

/**
 * Defines a handler interface for handling the results of asynchronous {@link Pento} read operations. Implementations
 * should consider that single PentoReadHandler will be utilized for a single PentoStore operation, and will
 * subsequently potentially be invoked by multiple {@link pento.store.PentoStore} threads. Therefore implementations
 * should ensure thread safety.
 *
 * @deprecated
 * @see PentoCallback
 */
public interface PentoReadHandler {

    /**
     * Callback implementation for a successful read operation.
     *
     * @param response The {@link PentoReadResponse} indicating the details of the successful operation
     */
    void success(PentoReadResponse response);

    /**
     * Callback implementation handling a failed read operation
     *
     * @param response The {@link FailedPentoReadResponse} indicating the details of the failed operation
     */
    void failure(FailedPentoReadResponse response);
}
