package pento.store;

import pento.model.Confidence;
import pento.model.Pento;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/13/12
 * Time: 8:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoResponse {

    Confidence getConfidence();

    Pento getPento();

}
