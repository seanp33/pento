package pento.store.mock.worker;

import pento.model.Distribution;
import pento.model.Pento;
import pento.response.PentoResponse;
import pento.store.worker.PentoStoreWorker;
import pento.store.mock.MockPentoResponse;

import javax.print.attribute.standard.Destination;
import java.util.Random;
import java.util.concurrent.Callable;

public class RandomLatencyWorker implements PentoStoreWorker<Pento, Distribution> {

    @Override
    public Callable execute(final Pento pento, final Distribution distribution) {
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
