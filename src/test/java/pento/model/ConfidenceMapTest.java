package pento.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConfidenceMapTest {


    @Test
    public void testRegistration(){
        ConfidenceMap map = new ConfidenceMap();
        map.register("cloud1", Confidence.GLOBAL);
        map.register("cloud2", Confidence.GLOBAL);
        map.register("cloud3", Confidence.UNIVERSAL);
        assertEquals(Confidence.GLOBAL, map.getForHost("cloud1"));
        assertEquals(Confidence.GLOBAL, map.getForHost("cloud2"));
        assertEquals(Confidence.UNIVERSAL, map.getForHost("cloud3"));
    }

    @Test
    public void testUnregister(){
        ConfidenceMap map = new ConfidenceMap();
        map.register("cloud1", Confidence.GLOBAL);
        assertEquals(Confidence.GLOBAL, map.getForHost("cloud1"));
        map.unregister("cloud1");
        assertNull(map.getForHost("cloud1"));
    }
}
