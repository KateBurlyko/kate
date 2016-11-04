import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class GetCoordinatasTest {
    @BeforeMethod
    public void setUp() {
        gc = new GetCoordinatas();
        inpu = new ArrayList<String>();
        coo = new ArrayList<Coordinata>();
        inpu.add("10.3265 56.35654");
        inpu.add("4569.50 54.234");
    }

    @AfterMethod
    public void tearDown() {
        ret.clear();
    }

    GetCoordinatas gc;
    ArrayList<String> inpu;
    ArrayList<Coordinata> coo;
    ArrayList ret;

    @Test
    public void getCoordinatas() {
        ArrayList out = new ArrayList();
        out.add(new Coordinata(10.3265, 56.35654));
        out.add(new Coordinata(4569.50, 54.234));
        ret = gc.getCoordinatas(inpu, coo);
        assertEquals(ret.size(), out.size());
    }
}