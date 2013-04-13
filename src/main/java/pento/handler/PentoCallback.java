package pento.handler;

/**
 * Handler interface defining a callback
 */
public interface PentoCallback<Callback, Error> {

    public void callback(Callback callback);

    public void error(Error error);
}
