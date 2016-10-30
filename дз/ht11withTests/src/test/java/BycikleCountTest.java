import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BycikleCountTest {
    Preparation p = new Preparation();
    Bycikle b = new Bycikle();

    @Test
    public void countTravel() throws MyExc {
        p.setUp();
        double k = b.countTravel(20, 1, 0, 0);
        assertEquals(0, k, 0.001);
        p.tearDown();
    }

    @Test
    public void timeToTravel() throws MyExc {
        p.setUp();
        double c = b.timeToTravel(20);
        assertEquals(0.180277, c, 0.001);
        p.tearDown();
    }
}