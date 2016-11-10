

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * entry and validation variables
 */
public class Input {

    /**
     * method reads from the keybords the values of variables and caugth InputMismatchException
     *
     * @param a first side
     * @param b second side
     * @param c second side
     * @return message
     */
    public void inputs(BigDecimal a, BigDecimal b, BigDecimal c) {
        Scanner in = new Scanner(System.in);
        String messa = "";
        System.out.print("input first side: ");
        a = in.nextBigDecimal();
        System.out.print("input second side: ");
        b = in.nextBigDecimal();
        System.out.print("input third side: ");
        c = in.nextBigDecimal();

        Traingl tra = new Traingl();
        tra.tri(a, b, c);
    }
}
