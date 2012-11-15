package pento;

import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.model.Statement;
import pento.store.PentoResponse;
import pento.store.mock.MockPentoStore;

public class SimpleDriver {

    public static void main(String[] args) throws Exception{
        final MockPentoStore store = new MockPentoStore();

        PentoWriteHandler handler = new PentoWriteHandler<PentoResponse>() {
            int count = 0;

            @Override
            public void success(PentoResponse response) {
                count += 1;
                System.out.println("Success! Pento written with confidence " + response.getConfidence());
                if (count == 10) {
                    System.out.println("would need to store.close()");
                    try {
                        store.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void error(PentoResponse response) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        for (int i = 0; i < 10; i++) {
            store.write(new Pento(new Statement("urn:sean#" + i, "color", "blue"), System.currentTimeMillis(), "TEST"), handler);
        }
    }
}
