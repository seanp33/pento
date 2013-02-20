package pento.store.worker;

import java.util.concurrent.Callable;

public interface PentoStoreWorker <Source, Sink> {

    Callable execute(Source source, Sink sink);
}
