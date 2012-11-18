package pento.store.mock;

import pento.model.Pento;
import pento.store.PentoResponse;
import pento.store.PentoStoreWorker;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomLatencyWorker implements PentoStoreWorker<Pento> {
    @Override
    public Callable<PentoResponse> execute(final Pento pento) {

        return new Callable<PentoResponse>() {
            @Override
            public PentoResponse call() throws Exception {
                Thread.sleep(randRange(1000, 7000));
                return new MockPentoResponse(pento);
            }
        };
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max + 1) - min) + min;
    }
}
