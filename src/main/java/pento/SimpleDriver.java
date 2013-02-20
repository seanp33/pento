package pento;

import pento.handler.PentoWriteHandler;
import pento.model.EmptyDistribution;
import pento.model.Pento;
import pento.model.Statement;
import pento.response.write.FailedPentoWriteResponse;
import pento.response.write.PentoWriteResponse;
import pento.store.DefaultPentoStore;
import pento.store.mock.worker.RandomLatencyWorkerFactory;
import pento.store.worker.EmptyContext;

import java.util.Arrays;

public class SimpleDriver {

    public static void main(String[] args) throws Exception {

        // TODO: fleshout the read worker factory impl. passing in null for the time being
        final DefaultPentoStore store = new DefaultPentoStore(null, new RandomLatencyWorkerFactory());

        PentoWriteHandler handler = new PentoWriteHandler<PentoWriteResponse>() {
            int count = 0;

            @Override
            public void success(PentoWriteResponse response) {
                count += 1;
                StringBuffer sb = new StringBuffer();
                sb.append("Success! Pento written:\n");
                sb.append(response.getPento());
                sb.append("\n");
                sb.append(response.getConfidence());
                sb.append("\n------------------------\n");
                System.out.println(sb.toString());
                if (count == 10) {
                    try {
                        store.close();
                        System.exit(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(FailedPentoWriteResponse response) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        EmptyContext context = new EmptyContext();
        for (int i = 0; i < 10; i++) {
            store.write(
                    new Pento(Arrays.asList(new Statement("urn:sean#" + i, "color", "blue")),
                            System.currentTimeMillis(), "TEST"), new EmptyDistribution(), handler, context);
        }
    }
}
