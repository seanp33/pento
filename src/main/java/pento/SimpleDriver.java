package pento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.EmptyDistribution;
import pento.model.Pento;
import pento.model.Statement;
import pento.op.PentoQuery;
import pento.response.read.FailedPentoReadResponse;
import pento.response.read.PentoReadResponse;
import pento.response.write.FailedPentoWriteResponse;
import pento.response.write.PentoWriteResponse;
import pento.store.DefaultPentoStore;
import pento.store.mock.worker.RandomLatencyReadResponseProducingWorkerFactory;
import pento.store.mock.worker.RandomLatencyWriteResponseProducingWorkerFactory;
import pento.store.worker.EmptyContext;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleDriver {

    private static final DefaultPentoStore store = new DefaultPentoStore(
            new RandomLatencyReadResponseProducingWorkerFactory(),
            new RandomLatencyWriteResponseProducingWorkerFactory());

    private static final AtomicInteger writeCount = new AtomicInteger(0);
    private static final AtomicInteger readCount = new AtomicInteger(0);

    private static void handleShutDown() {
        if (writeCount.get() == 10 && readCount.get() == 10) {
            try {
                store.close();
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        PentoWriteHandler writeHandler = new PentoWriteHandler() {

            @Override
            public void success(PentoWriteResponse response) {
                writeCount.incrementAndGet();
                StringBuffer sb = new StringBuffer();
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                sb.append("WRITE: " + response.getOrigin() + " with confidence " + response.getConfidence() + "\n");
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                System.out.println(sb);
                handleShutDown();
            }

            @Override
            public void failure(FailedPentoWriteResponse response) {
                writeCount.incrementAndGet();
            }
        };

        PentoReadHandler readHandler = new PentoReadHandler() {
            @Override
            public void success(PentoReadResponse response) {
                readCount.incrementAndGet();
                StringBuffer sb = new StringBuffer();
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                sb.append("READ: " + response.getOrigin() + " with confidence " + response.getConfidence() + "\n");
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                System.out.println(sb);
                handleShutDown();
            }

            @Override
            public void failure(FailedPentoReadResponse response) {
                readCount.incrementAndGet();
            }
        };

        for (int i = 0; i < 10; i++) {
            long time = System.currentTimeMillis();
            final Statement stmt = new Statement("urn:sean#" + i, "color", "blue");
            store.write(new Pento(Arrays.asList(stmt), time, "TEST"), new EmptyDistribution(), writeHandler, new EmptyContext());
            store.read(new SubjectQuery(stmt.getSubject()), new EmptyDistribution(), readHandler, new EmptyContext());

        }
    }
}

class SubjectQuery implements PentoQuery<String> {

    private String query;

    SubjectQuery(String subject) {
        this.query = "select * from pento where subject = '" + subject + "'";
    }

    @Override
    public String getQuery() {
        return query;
    }
}
