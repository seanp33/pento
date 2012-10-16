package pento.store.mock;

import pento.model.Pento;
import pento.store.PentoStoreWorker;

import java.util.concurrent.Callable;

public class RandomLatencyWorker implements PentoStoreWorker<Callable<Pento>, Pento> {
    @Override
    public Callable<Pento> execute(final Pento pento) {

        return new Callable<Pento>(){
            @Override
            public Pento call() throws Exception {
                Thread.sleep(2000);
                return pento;
            }
        };
    }
}
