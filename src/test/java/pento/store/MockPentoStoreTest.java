package pento.store;


import org.junit.Ignore;
import org.junit.Test;
import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.model.Statement;
import pento.response.PentoResponse;
import pento.store.mock.MockPentoStore;
import pento.store.mock.worker.RandomLatencyWorkerFactory;

@Ignore
public class MockPentoStoreTest {

    public static final String ORIGIN = "unit test";

    @Test
    public void base_test_of_one_request() throws Exception {
        MockPentoStore store = new MockPentoStore(null, new RandomLatencyWorkerFactory());

        PentoWriteHandler handler = new PentoWriteHandler<PentoResponse>() {
            @Override
            public void success(PentoResponse response) {
                System.out.println("Success! Pento written with confidence " + response.getConfidence());
            }

            @Override
            public void error(PentoResponse response) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        for (int i = 0; i < 100; i++) {
            store.write(new Pento(new Statement("urn:sean#" + i, "color", "blue"), System.currentTimeMillis(), ORIGIN), handler);
        }
    }
}
