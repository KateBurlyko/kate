import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.*;
import static org.testng.Assert.*;

public class TrainglTest {
    Traingl t = new Traingl();

    @DataProvider(name = "sides")
    public Object[][] numbers() {
        return new Object[][]{
                {NaN, 5, 5},
                {5, NaN, 5},
                {5, 5, NaN},
                {NaN, NaN, NaN},
                {NEGATIVE_INFINITY, 5, 5},
                {8, NEGATIVE_INFINITY, 5},
                {5, 5, NEGATIVE_INFINITY},
                {NEGATIVE_INFINITY, NEGATIVE_INFINITY, NEGATIVE_INFINITY},
                {POSITIVE_INFINITY, 5, 5},
                {8, POSITIVE_INFINITY, 5},
                {8, 5, POSITIVE_INFINITY},
                {POSITIVE_INFINITY, POSITIVE_INFINITY, POSITIVE_INFINITY},
                {(-8), (5), (5)},
                {(5), (-8), (5)},
                {(5), (5), (-8)},
                {(0), (0), (0)},
                {Double.MAX_VALUE, (5), (5)}
        };
    }

    @DataProvider(name = "side")
    public Object[][] number() {
        return new Object[][]{
                {"traingl is equilateral", (5), (5), (5)},
                {"traingl is usual", (5.0000000000000011), (5.0000000000000021), (5.0000000000000031)},
                {"traingle is isosceles", (5), (5), (6)},
                {"traingle is usual", (5), (6), (7)},
                {"traingle is usual", (5.0000000000000000000001), (4.999999999999999999999), (7)},
                {"traingle is usual", (5.5), (6.66), (7.777)},
                {"traingle is usual", (6 / 2), (6 / 3), (7 / 4)},
                {"traingl is equilateral", (5 / 5), (5 / 5), (5 / 5)},
                {"traingle is isosceles", Double.MIN_VALUE, (5 / 5), (5 / 5)},
                {"traingle is isosceles", Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {"traingl is equilateral", Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {"traingl is equilateral", Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}
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