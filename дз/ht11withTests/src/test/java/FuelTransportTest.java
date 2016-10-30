import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class FuelTransportTest {
    @Before
    public void setUp() {
        p = new Preparation();
        ft = new FuelTransport();
    }

    Preparation p;
    FuelTransport ft;

    @Test
    public void timeToTravel() throws MyExc {
        p.setUp();
        double c = ft.timeToTravel(60);
        assertEquals(0.06009, c, 0.001);
        p.tearDown();
    }

    @Test
    public void countTravel() throws MyExc {
        p.setUp();
        double k = ft.countTravel(60, 37, 10, 0.50);
        assertEquals(0.0224878, k, 0.001);
        p.tearDown();
    }
}