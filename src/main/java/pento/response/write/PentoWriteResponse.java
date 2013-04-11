package pento.response.write;

import pento.model.Pento;
import pento.response.Response;

public interface PentoWriteResponse extends Response {

    Pento getPento();

    Object getBody();

}
