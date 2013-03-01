package pento.response.read;

import pento.model.Pento;
import pento.op.PentoQuery;

public interface PentoReadResponse {

    Iterable<Pento> getPenti();

    PentoQuery getPentoQuery();

    String getOrigin();
}
