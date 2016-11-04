import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.*;
import static org.testng.Assert.*;

public class TrainglTest {
    Traingl t = new Traingl();

    @DataProvider(name = "sides")
    public Object[][] numbers() {
        return new Object[][]{
                {new Double(NaN), new Double(5), new Double(5)},
                {new Double(5), new Double(NaN), new Double(5)},
                {new Double(5), new Double(5), new Double(NaN)},
                {new Double(NaN), new Double(NaN), new Double(NaN)},
                {new Double(NEGATIVE_INFINITY), new Double(5), new Double(5)},
                {new Double(8), new Double(NEGATIVE_INFINITY), new Double(5)},
                {new Double(5), new Double(5), new Double(NEGATIVE_INFINITY)},
                {new Double(NEGATIVE_INFINITY), new Double(NEGATIVE_INFINITY), new Double(NEGATIVE_INFINITY)},
                {new Double(POSITIVE_INFINITY), new Double(5), new Double(5)},
                {new Double(8), new Double(POSITIVE_INFINITY), new Double(5)},
                {new Double(8), new Double(5), new Double(POSITIVE_INFINITY)},
                {new Double(POSITIVE_INFINITY), new Double(POSITIVE_INFINITY), new Double(POSITIVE_INFINITY)},
                {new Double(-8), new Double(5), new Double(5)},
                {new Double(5), new Double(-8), new Double(5)},
                {new Double(5), new Double(5), new Double(-8)},
                {new Double(0), new Double(0), new Double(0)},
        };
    }

    @DataProvider(name = "side")
    public Object[][] number() {
        return new Object[][]{
                {"traingl is equilateral", new Double(5), new Double(5), new Double(5)},
                {"traingl is usual", new Double(5.0000000000000011), new Double(5.0000000000000021), new Double(5.0000000000000031)},
                {"traingle is isosceles", new Double(5), new Double(5), new Double(6)},
                {"traingle is usual", new Double(5), new Double(6), new Double(7)},
                {"traingle is usual", new Double(5.0000000000000000000001), new Double(4.999999999999999999999), new Double(7)},
                {"traingle is usual", new Double(5.5), new Double(6.66), new Double(7.777)},
                {"traingle is usual", new Double(6 / 2), new Double(6 / 3), new Double(7 / 4)},
                {"traingl is equilateral", new Double(5 / 5), new Double(5 / 5), new Double(5 / 5)}
        };
    }

    @Test(dataProvider = "sides")
    public void NegativeTestTriangle(double a, double b, double c) {
        String res = t.tri(a, b, c);
        assertEquals(res, "This task does not have roots");
    }

    @Test(dataProvider = "side")
    public void PositiveTestTriangle(String expected, double a, double b, double c) {
        String res = t.tri(a, b, c);
        assertEquals(res, expected);
    }
}