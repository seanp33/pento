package pento.store.mock.worker;

import pento.model.Pento;
import pento.response.write.PentoWriteResponse;
import pento.store.mock.MockPentoWriteResponse;
import pento.store.worker.PentoStoreWorker;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomLatencyWorker implements PentoStoreWorker<Pento> {

    @Override
    public Callable execute(final Pento pento) {
        return new Callable<PentoWriteResponse>() {
            @Override
            public PentoWriteResponse call() throws Exception {
                Thread.sleep(randRange(1000, 7000));
                return new MockPentoWriteResponse(pento);
            }
        };
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max + 1) - min) + min;
    }
}
