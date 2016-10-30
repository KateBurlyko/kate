import org.junit.*;

import java.util.ArrayList;

import static com.sun.deploy.perf.DeployPerfUtil.clear;
import static org.junit.Assert.*;

public class CountDistanceTest {
    @Before
    public void setUp() {
        cd = new CountDistance();
    }

    @After
    public void tearDown() {
        coor.clear();
    }

    private CountDistance cd;
    ArrayList coor = new ArrayList();

    @Test
    public void countDistancePozitiveCoordinates() throws MyExc {
        coor.add(new Coordinata(4.0D, 5.0D));
        coor.add(new Coordinata(10.0D, 8.0D));
        double d = cd.countDistance(coor);
        assertEquals(6.7082039325, d, 0.0001);
    }

    @Test
    public void countDistanceNegativeCoordinates() throws MyExc {
        coor.add(new Coordinata(-2.0D, -5.0D));
        coor.add(new Coordinata(-15.0D, -8.0D));
        double d = cd.countDistance(coor);
        assertEquals(13.34166, d, 0.0001);
    }

    @Test
    public void countDistanceSameCoordinates() throws MyExc {
        coor.add(new Coordinata(4.0D, 5.0D));
        coor.add(new Coordinata(4.0D, 5.0D));
        double d = cd.countDistance(coor);
        assertEquals(0, d, 0.0001);
    }

    @Test
    public void countDistanceAlmostTheSameCoordinates() throws MyExc {
        coor.add(new Coordinata(4.0000000000000000000000000000000001, 5.0D));
        coor.add(new Coordinata(4.0D, 5.00000000000000000000000000000000000000000000001));
        double d = cd.countDistance(coor);
        assertEquals(0, d, 1);
    }

    @Test(expected = MyExc.class)
    public void CountDistanceOneCoordinates() throws MyExc {
        coor.add(new Coordinata(4.0, 5.0D));
        double d = cd.countDistance(coor);
    }

}