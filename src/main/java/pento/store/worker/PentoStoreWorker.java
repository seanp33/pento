package pento.store.worker;

import java.util.concurrent.Callable;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/15/12
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoStoreWorker <Source> {

    Callable execute(Source source);
}
