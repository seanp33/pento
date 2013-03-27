package pento.response.read;

import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.Response;

public interface PentoReadResponse extends Response {

    Iterable<Pento> getPenti();

    PentoQuery getPentoQuery();

}
