package pento;

import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.model.Statement;
import pento.store.PentoResponse;
import pento.store.mock.MockPentoStore;

public class SimpleDriver {

    public static void main(String[] args) {
        MockPentoStore store = new MockPentoStore();

        PentoWriteHandler handler = new PentoWriteHandler<Pento>() {
	    int count = 0;
	    
            @Override
            public void success(Pento pento, PentoResponse response) {
                count += 1;
		System.out.println("Success! Pento written with confidence " + response.getConfidence());
		if(count == 9){
		    System.out.println("would need to store.close()");
		}
            }

            @Override
            public void error(Pento pento, PentoResponse response) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        for (int i = 0; i < 10; i++) {
            store.write(new Pento(new Statement("urn:sean#" + i, "color", "blue"), System.currentTimeMillis(), "TEST"), handler);
        }
    }
}
