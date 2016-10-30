import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Preparation {
    private static CountDistance ce;
    static ArrayList coord = new ArrayList();

    @Before
    public static void setUp() throws MyExc {
        ce = new CountDistance();
        coord.add(new Coordinata(4, 5));
        coord.add(new Coordinata(6, 8));
        ce.countDistance(coord);
    }

    @After
    public static void tearDown() {
        coord.clear();
    }
}