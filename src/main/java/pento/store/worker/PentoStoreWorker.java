package pento.store.worker;

import java.util.concurrent.Callable;

public interface PentoStoreWorker <Source> {

    Callable execute(Source source);
}
