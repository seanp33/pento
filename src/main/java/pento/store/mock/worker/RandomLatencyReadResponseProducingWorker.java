package pento.store.mock.worker;

import pento.op.PentoQuery;
import pento.response.read.PentoReadResponse;
import pento.store.mock.MockPentoReadResponse;
import pento.store.worker.PentoStoreWorker;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomLatencyReadResponseProducingWorker implements PentoStoreWorker<PentoQuery> {

    @Override
    public Callable execute(final PentoQuery query) {
        return new Callable<PentoReadResponse>() {
            @Override
            public PentoReadResponse call() throws Exception {
                Thread.sleep(randRange(1000, 7000));
                return new MockPentoReadResponse(query);
            }
        };
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max + 1) - min) + min;
    }
}
