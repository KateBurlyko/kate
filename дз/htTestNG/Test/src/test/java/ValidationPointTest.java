import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.NamedNodeMap;

import java.util.ArrayList;

import static java.lang.Double.NaN;

public class ValidationPointTest {
    @DataProvider(name = "points")
    public Object[][] getPoints() {
        return new Object[][]{
                {new Coordinata(4, 5), new Coordinata(NaN, NaN)},
                {new Coordinata(4, 5), new Coordinata(4, 5)},
                {new Coordinata(NaN, 5), new Coordinata(5, NaN)},
                {new Coordinata(NaN, NaN), new Coordinata(4, 5)},
                {new Coordinata(0, 0), new Coordinata(0, 0)},
                {new Coordinata(-8, -8), new Coordinata(-8, -8)}
        };
    }

    @Test(dataProvider = "points", expectedExceptions = MyExc.class)
    public void countDistancePozitiveCoordinates(Coordinata x, Coordinata y) throws MyExc {
        ArrayList ar = new ArrayList();
        ar.add(x);
        ar.add(y);
        ValidationPoint vp = new ValidationPoint();
        vp.validate(ar);
    }
}