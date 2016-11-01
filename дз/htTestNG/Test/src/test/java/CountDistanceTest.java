import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class CountDistanceTest {
    @AfterMethod
    public void tearDown() {
        coor.clear();
    }

    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {6.7082039325, new Coordinata(4, 5), new Coordinata(10, 8)},
                {13.34166, new Coordinata(-2, -5), new Coordinata(-15, -8)},
                {0, new Coordinata(4, 5), new Coordinata(4, 5)}
        };
    }

    private CountDistance cd = new CountDistance();
    ArrayList coor = new ArrayList();

    @Test(dataProvider = "points")
    public void countDistancePozitiveCoordinates(double expected, Coordinata x, Coordinata y) throws MyExc {
        ArrayList ar = new ArrayList();
        ar.add(x);
        ar.add(y);
        assertEquals(new CountDistance().countDistance(ar), expected, 0.001);
    }

    @Test(expectedExceptions = MyExc.class)
    public void CountDistanceOneCoordinates() throws MyExc {
        coor.add(new Coordinata(4.0, 5.0D));
        double d = cd.countDistance(coor);
    }

}