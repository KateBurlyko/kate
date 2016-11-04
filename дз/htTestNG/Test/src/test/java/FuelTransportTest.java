import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class FuelTransportTest {
    FuelTransport ft = new FuelTransport();
    CountDistance ce = new CountDistance();
    static ArrayList coord = new ArrayList();

    @BeforeMethod
    public void setUp() throws MyExc {

        coord.add(new Coordinata(4, 5));
        coord.add(new Coordinata(6, 8));
        ce.countDistance(coord);
    }

    @AfterMethod
    public void tearDown() {
        coord.clear();
    }

    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {new Double(0), new Double(0), new Double(0), new Double(0)},
                {new Double(-5), new Double(-5), new Double(-5), new Double(-6)},
                {new Double(5), new Double(-5), new Double(-5), new Double(-6)},
                {new Double(-5), new Double(5), new Double(-5), new Double(-6)},
                {new Double(-5), new Double(-5), new Double(5), new Double(-6)},
                {new Double(-5), new Double(-5), new Double(-5), new Double(6)},
                {new Double(5), new Double(5), new Double(-5), new Double(-6)},
                {new Double(-5), new Double(-5), new Double(5), new Double(6)},
                {new Double(-5), new Double(5), new Double(5), new Double(-6)},
                {new Double(10e1), new Double(-5), new Double(-5), new Double(-6)}
        };
    }
    @DataProvider(name = "point")
    public Object[][] getPoint() {
        return new Object[][]{
                {new Double(0)},
                {new Double(-5)},
        };
    }

    private CountDistance cd = new CountDistance();
    // ArrayList coor = new ArrayList();

    @Test
    public void countTime() throws MyExc {
        double c = ft.timeToTravel(60);
        assertEquals(c, 0.18956, 0.001);
    }


    @Test
    public void countTravel() throws MyExc {
        double k = ft.countTravel(60, 37, 10, 0.50);
        assertEquals(0.0224878, k, 0.001);
    }
    @Test(expectedExceptions = ArithmeticException.class, dataProvider = "points")
    public void countTravel(double sp, double ps, double fc, double c) {
        ft.countTravel(sp, ps, fc, c);
    }
    @Test(expectedExceptions = ArithmeticException.class, dataProvider = "point")
    public void negativeTime(double s) throws MyExc {
        ft.timeToTravel(s);
    }
}