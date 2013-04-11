package pento.store.worker;

import java.util.concurrent.Callable;

/**
 * Worker against a Pento store, local or remote
 * @param <Source>
 */
public interface PentoStoreWorker <Member, Source> {

    Callable execute(Source source);

    Member location();
}
