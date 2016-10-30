import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class GetCoordinatasTest {
    @Before
    public void setUp() {
        gc = new GetCoordinatas();
        inpu = new ArrayList<String>();
        coo = new ArrayList<Coordinata>();
        inpu.add("10.3265 56.35654");
        inpu.add("4569.50 54.234");
    }

    @After
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