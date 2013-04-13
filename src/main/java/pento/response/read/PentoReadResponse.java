package pento.response.read;

import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.Response;

/**
 * @see pento.handler.PentoCallback
 * @deprecated
 */
public abstract class PentoReadResponse implements Response {

    public abstract Iterable<Pento> getPenti();

    public abstract PentoQuery getPentoQuery();

}
