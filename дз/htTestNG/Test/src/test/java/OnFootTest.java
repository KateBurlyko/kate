import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OnFootTest {
    OnFoot of = new OnFoot();


    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {new Double(0), new Double(0), new Double(0), new Double(0)},
                {new Double(-5), new Double(-8), new Double(0), new Double(0)},
                {new Double(-5), new Double(1), new Double(0), new Double(0)},
                {new Double(5), new Double(-1), new Double(0), new Double(0)}
        };
    }

    @DataProvider(name = "poi")
    public Object[][] getPoi() {
        return new Object[][]{
                {new Double(0)},
                {new Double(-5)},
        };
    }

    @Test(expectedExceptions = ArithmeticException.class, dataProvider = "points")
    public void countDistancePozitiveCoordinates(Double sp, Double ps, Double fc, Double c) {
        of.countTravel(sp, ps, fc, c);
    }


    @Test(expectedExceptions = ArithmeticException.class, dataProvider = "poi")
    public void timeToTravel(double sp) throws MyExc {
        double k = of.timeToTravel(sp);
    }

    @Test
    public void countTravel() throws MyExc {
        double c = of.countTravel(5, 1, 0, 0);
        assertEquals(0, c, 0.001);
    }

    @Test
    public void countTime() throws MyExc {
        double c = of.timeToTravel(5);
        assertEquals(c, 1.20185, 0.001);
    }
}
