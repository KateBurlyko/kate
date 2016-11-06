import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class TrainglTest {
    Traingl t = new Traingl();

    @DataProvider(name = "sides")
    public Object[][] numbers() {
        return new Object[][]{
                {BigDecimal.valueOf(-8), BigDecimal.valueOf(5), BigDecimal.valueOf(5)},
                {BigDecimal.valueOf(5), BigDecimal.valueOf(-8), BigDecimal.valueOf(5)},
                {BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(-8)},
                {BigDecimal.valueOf(8), BigDecimal.valueOf(-5), BigDecimal.valueOf(5)},
                {BigDecimal.valueOf(5), BigDecimal.valueOf(8), BigDecimal.valueOf(-5)},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(1), BigDecimal.valueOf(0)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(0), BigDecimal.valueOf(0)},
                {BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(1)},
        };
    }

    @DataProvider(name = "eror")
    public Object[][] nu() {
        return new Object[][]{
                {BigDecimal.valueOf(1), BigDecimal.valueOf(1), null},
                {null, BigDecimal.valueOf(1), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(1), null, BigDecimal.valueOf(1)}
        };
    }

    @Test(dataProvider = "eror", expectedExceptions = NullPointerException.class)
    public void iangle(BigDecimal a1, BigDecimal b1, BigDecimal c1) {
        String res = t.tri(a1, b1, c1);
        assertEquals(res, "This task does not have roots");
    }

    @DataProvider(name = "side")
    public Object[][] number() {
        return new Object[][]{
                {"traingle is equilateral", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5)},
                {"traingle is usual", BigDecimal.valueOf(5.000011), BigDecimal.valueOf(5.000021), BigDecimal.valueOf(5.000031)},
                {"traingle is isosceles", BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(6)},
                {"traingle is usual", BigDecimal.valueOf(5), BigDecimal.valueOf(6), BigDecimal.valueOf(7)},
                {"traingle is usual", BigDecimal.valueOf(5.0000001), BigDecimal.valueOf(4.9999999), BigDecimal.valueOf(7)},
                {"traingle is usual", BigDecimal.valueOf(5.5), BigDecimal.valueOf(6.66), BigDecimal.valueOf(7.777)},
                {"traingle is usual", BigDecimal.valueOf(6 / 2), BigDecimal.valueOf(6 / 3), BigDecimal.valueOf(7 / 4)},
                {"traingle is equilateral", BigDecimal.valueOf(5 / 5), BigDecimal.valueOf(5 / 5), BigDecimal.valueOf(5 / 5)},
        };
    }

    @Test(dataProvider = "sides")
    public void NegativeTestTriangle(BigDecimal a1, BigDecimal b1, BigDecimal c1) {
        String res = t.tri(a1, b1, c1);
        assertEquals(res, "This task does not have roots");
    }

    @Test(dataProvider = "side")
    public void PositiveTestTriangle(String expected, BigDecimal a1, BigDecimal b1, BigDecimal c1) {
        String res = t.tri(a1, b1, c1);
        assertEquals(res, expected);
    }
}