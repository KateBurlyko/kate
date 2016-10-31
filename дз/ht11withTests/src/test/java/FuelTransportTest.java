import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class FuelTransportTest {

    Preparation p = new Preparation();
    FuelTransport ft = new FuelTransport();

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
    @Test(expected = ArithmeticException.class)
    public void negativeCountTravel() throws MyExc {
        p.setUp();
        ft.countTravel(0, 0, 0, 0);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeTime() throws MyExc {
        p.setUp();
        ft.timeToTravel(0);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeDataCountTravel() throws MyExc {
        p.setUp();
        ft.countTravel(-5, -8, -5, 9);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeSomeDataCountTravel() throws MyExc {
        p.setUp();
        ft.countTravel(-5, 8, -5, 9);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeDataTime() throws MyExc {
        p.setUp();
        ft.timeToTravel(-5);
        p.tearDown();
    }
}