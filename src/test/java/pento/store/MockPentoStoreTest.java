package pento.store;


import org.junit.Ignore;
import org.junit.Test;
import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.model.Statement;
import pento.store.mock.MockPentoStore;

@Ignore
public class MockPentoStoreTest {

    public static final String ORIGIN = "unit test";

    @Test
    public void base_test_of_one_request() throws Exception {
        MockPentoStore store = new MockPentoStore();

        PentoWriteHandler handler = new PentoWriteHandler<Pento>() {
            @Override
            public void success(Pento pento, PentoResponse response) {
                System.out.println("Success! Pento written with confidence " + response.getConfidence());
            }

            @Override
            public void error(Pento pento, PentoResponse response) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        for (int i = 0; i < 100; i++) {
            store.write(new Pento(new Statement("urn:sean#" + i, "color", "blue"), System.currentTimeMillis(), ORIGIN), handler);
        }
    }
}
