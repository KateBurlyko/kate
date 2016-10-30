import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class ValidationPointTest {
    @After
    public void tearDown() {
        coor.clear();
    }

    ArrayList coor = new ArrayList();

    @Test(expected = MyExc.class)
    public void oneCheckPoint() throws MyExc {
        coor.add(new Coordinata(0, 5));
        ValidationPoint vp = new ValidationPoint();
        vp.validate(coor);
    }

    @Test(expected = MyExc.class)
    public void sameFirstAndLastCheckPoints() throws MyExc {
        coor.add(new Coordinata(0, 5));
        coor.add(new Coordinata(0, 5));
        ValidationPoint vp = new ValidationPoint();
        vp.validate(coor);
    }
}