package pento;

import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.model.Statement;
import pento.store.PentoResponse;
import pento.store.mock.MockPentoStore;
import pento.store.mock.RandomLatencyWorkerFactory;

public class SimpleDriver {

    public static void main(String[] args) throws Exception {

        // TODO: fleshout the read worker factory impl. passing in null for the time being
        final MockPentoStore store = new MockPentoStore(new RandomLatencyWorkerFactory(), null);

        PentoWriteHandler handler = new PentoWriteHandler<PentoResponse>() {
            int count = 0;

            @Override
            public void success(PentoResponse response) {
                count += 1;
                StringBuffer sb = new StringBuffer();
                sb.append("Success! Pento written:\n");
                sb.append(response.getPento());
                sb.append("\n");
                sb.append(response.getConfidence());
                sb.append("\n------------------------\n");
                System.out.println(sb.toString());
                if (count == 10) {
                    System.out.println("would need to store.close()");
                    try {
                        store.close();
                        System.exit(0);
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
