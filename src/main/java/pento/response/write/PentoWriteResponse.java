package pento.response.write;

import pento.model.Pento;
import pento.response.Response;

/**
 * @deprecated
 *
 * @see pento.handler.PentoCallback
 */
public interface PentoWriteResponse extends Response {

    Pento getPento();

}
