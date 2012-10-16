package pento.store;

/**
 * Created by IntelliJ IDEA.
 * User: smonaghan
 * Date: 10/15/12
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PentoStoreWorker <Result,Source> {

    Result execute(Source source);
}
