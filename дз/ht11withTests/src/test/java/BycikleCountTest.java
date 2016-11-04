import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BycikleCountTest {
    Preparation p = new Preparation();
    Bycikle b = new Bycikle();

    @Test
    public void countTravel() throws MyExc {
        p.setUp();
        double k = b.countTravel(20, 1, 6, 8);
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

    @Test(expected = ArithmeticException.class)
    public void negativeCountTravel() throws MyExc {
        p.setUp();
        b.countTravel(0, 0, 0, 0);
        p.tearDown();
    }

    @Test(expected = ArithmeticException.class)
    public void negativeTime() throws MyExc {
        p.setUp();
        b.timeToTravel(0);
        p.tearDown();
    }

    @Test(expected = ArithmeticException.class)
    public void negativeDataCountTravel() throws MyExc {
        p.setUp();
        b.countTravel(-5, -8, 0, 0);
        p.tearDown();
    }

    @Test(expected = ArithmeticException.class)
    public void negativeOneDataCountTravel() throws MyExc {
        p.setUp();
        b.countTravel(-5, 1, 0, 0);
        p.tearDown();
    }

    @Test(expected = ArithmeticException.class)
    public void negativeDataTime() throws MyExc {
        p.setUp();
        b.timeToTravel(-5);
        p.tearDown();
    }
}