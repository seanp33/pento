package pento.store.mock;

import pento.model.Pento;
import pento.store.PentoStoreWorker;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomLatencyWorker implements PentoStoreWorker<Callable<Pento>, Pento> {
    @Override
    public Callable<Pento> execute(final Pento pento) {

        return new Callable<Pento>(){
            @Override
            public Pento call() throws Exception {
                Thread.sleep(randRange(1000, 7000));
                return pento;
            }
        };
    }

    private static int randRange(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max+1) - min) + min;
    }
}
