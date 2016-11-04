import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OnFootTest {
    OnFoot of = new OnFoot();
    Preparation p = new Preparation();

    @Test
    public void timeToTravel() throws MyExc {
        p.setUp();
        double k = of.timeToTravel(3);
        assertEquals(1.20185, k, 0.001);
        p.tearDown();
    }

    @Test
    public void countTravel() throws MyExc {
        p.setUp();
        double c = of.countTravel(5, 1, 0, 0);
        assertEquals(0, c, 0.001);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeCountTravel() throws MyExc {
        p.setUp();
       of.countTravel(-8, 1, 0, 0);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeTime() throws MyExc {
        p.setUp();
        of.timeToTravel(0);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeDataCountTravel() throws MyExc {
        p.setUp();
        of.countTravel(-5, -8, 0, 0);
        p.tearDown();
    }
    @Test(expected = ArithmeticException.class)
    public void negativeDataTime() throws MyExc {
        p.setUp();
        of.timeToTravel(-5);
        p.tearDown();
    }
}
