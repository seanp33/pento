package pento.store.mock.worker;

import pento.model.Pento;
import pento.store.mock.MockPentoWriteResponse;
import pento.store.worker.PentoStoreWorker;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomLatencyWriteResponseProducingWorker implements PentoStoreWorker<Object, Pento> {

    @Override
    public Callable execute(final Pento pento) {
        return new Callable<MockPentoWriteResponse>() {
            @Override
            public MockPentoWriteResponse call() throws Exception {
                Thread.sleep(randRange(1000, 7000));
                return new MockPentoWriteResponse(pento);
            }
        };
    }

    @Override
    public Object location() {
        return "";
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max + 1) - min) + min;
    }
}
