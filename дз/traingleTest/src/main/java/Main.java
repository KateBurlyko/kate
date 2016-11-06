import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * initialized variables and call methods accordin to the task
 */
public class Main {

    /**
     * @param args - conveys the name of the variable returns the value of a variable
     */
    public static void main(String[] args) {
        ArrayList<Double> sides = new ArrayList<Double>(3);
        BigDecimal a = BigDecimal.valueOf(0.0);
        BigDecimal b = BigDecimal.valueOf(0.0);
        BigDecimal c = BigDecimal.valueOf(0.0);
        try {
            Input in = new Input();
            in.inputs(a, b, c);
        } catch (InputMismatchException e) {
            System.out.print("error");
            return;
        }

    }
}
