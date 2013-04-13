package pento;

import pento.handler.PentoCallback;
import pento.model.EmptyDistribution;
import pento.model.Pento;
import pento.model.Statement;
import pento.op.PentoQuery;
import pento.response.read.FailedPentoReadResponse;
import pento.response.read.PentoReadResponse;
import pento.response.write.FailedPentoWriteResponse;
import pento.response.write.PentoWriteResponse;
import pento.store.DefaultPentoStore;
import pento.store.mock.MockPentoReadResponse;
import pento.store.mock.MockPentoWriteResponse;
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

    private static final int COUNT = 5;

    private static void tryQuit() {
        if (writeCount.get() == COUNT && readCount.get() == COUNT) {
            try {
                store.close();
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        PentoCallback readCallback = new PentoCallback<MockPentoReadResponse, Throwable>() {
            @Override
            public void callback(MockPentoReadResponse pentoReadResponse) {
                readCount.incrementAndGet();
                StringBuffer sb = new StringBuffer();
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                sb.append("READ: " + pentoReadResponse.getOrigin() + " with confidence " + pentoReadResponse.getConfidence() + "\n");
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                System.out.println(sb);
                tryQuit();
            }

            @Override
            public void error(Throwable throwable) {
                readCount.incrementAndGet();
                System.out.println("FAILED READ!!! ");
                tryQuit();
            }
        };

        PentoCallback writeCallback = new PentoCallback<MockPentoWriteResponse, Throwable>() {
            @Override
            public void callback(MockPentoWriteResponse success) {
                writeCount.incrementAndGet();
                StringBuffer sb = new StringBuffer();
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                sb.append("WRITE: " + success.getOrigin() + " with confidence " + success.getConfidence() + "\n");
                sb.append(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
                System.out.println(sb);
                tryQuit();
            }

            @Override
            public void error(Throwable throwable) {
                writeCount.incrementAndGet();
                System.out.println("FAILED WRITE!!! ");
                tryQuit();
            }
        };


        for (int i = 0; i < COUNT; i++) {
            long time = System.currentTimeMillis();
            final Statement stmt = new Statement("urn:sean#" + i, "foaf:mbox", "smonaghan000@gmail.com", time, "TEST");
            store.write(new Pento(Arrays.asList(stmt)), new EmptyDistribution(), writeCallback, new EmptyContext());
            store.read(new SubjectQuery(stmt.getSubject()), new EmptyDistribution(), readCallback, new EmptyContext());

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
