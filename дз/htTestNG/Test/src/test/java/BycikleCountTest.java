import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class BycikleCountTest {
    Bycikle b = new Bycikle();
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
                {new Double(-5), new Double(-8), new Double(0), new Double(0)},
                {new Double(-5), new Double(1), new Double(0), new Double(0)},
                {new Double(5), new Double(-1), new Double(0), new Double(0)}
        };
    }

    @Test(expectedExceptions = ArithmeticException.class, dataProvider = "points")
    public void countDistancePozitiveCoordinates(Double sp, Double ps, Double fc, Double c) {
        b.countTravel(sp, ps, fc, c);
    }

    @DataProvider(name = "point")
    public Object[][] getPoint() {
        return new Object[][]{
                {new Double(0)},
                {new Double(-5)}
        };
    }

    @Test(expectedExceptions = ArithmeticException.class, dataProvider = "point")
    public void countTimeToTravel(Double spe) {
        b.timeToTravel(spe);
    }

    @Test
    public void countTravel() {
        double k = b.countTravel(20, 1, 0, 0);
        assertEquals(0, k);
    }

    @Test
    public void timeToTravel() throws MyExc {
        double c = b.timeToTravel(20);
        assertEquals(c, 0.180277, 0.0001);
    }
}