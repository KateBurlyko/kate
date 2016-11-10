import java.math.BigDecimal;
import java.util.Scanner;

/**
 * entry and validation variables
 */
public class Input {

    /**
     * method reads from the keybords the values of variables and caugth InputMismatchException
     *
     *
     * @return
     */
    public BigDecimal inputs() {
        Scanner in = new Scanner(System.in);
        System.out.print("input first side: ");
        return in.nextBigDecimal();
    }
}
