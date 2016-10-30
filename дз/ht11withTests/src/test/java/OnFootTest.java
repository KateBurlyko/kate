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
}
