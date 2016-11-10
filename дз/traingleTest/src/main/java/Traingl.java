import java.math.BigDecimal;

/**
 * method computes the type of figure
 */
public class Traingl {
    /**
     * It compares side and computes the type of figure
     *
     * @param a first side
     * @param b second side
     * @param c second side
     */
    public String tri(BigDecimal a, BigDecimal b, BigDecimal c) throws InputExec {
        String message = " ";
        if (a == null) throw new InputExec("wrong data");
        {
        }

        if (a.compareTo(BigDecimal.ZERO) == (-1) || a.compareTo(BigDecimal.ZERO) == 0
                || b.compareTo(BigDecimal.ZERO) == (-1) || b.compareTo(BigDecimal.ZERO) == 0
                || c.compareTo(BigDecimal.ZERO) == (-1) || c.compareTo(BigDecimal.ZERO) == 0
                || (a.add(b)).compareTo(c) == (-1)
                || (b.add(c)).compareTo(a) == (-1)
                || (c.add(a)).compareTo(b) == (-1)) {
            message = "This task does not have roots";
        } else if (a.compareTo(b) == 0 && a.compareTo(c) == 0 && c.compareTo(b) == 0) {
            message = "traingle is equilateral";
        } else if (a.compareTo(b) == 0 || a.compareTo(c) == 0 || c.compareTo(b) == 0) {
            message = "traingle is isosceles";
        } else if (a.compareTo(b) != 0 || a.compareTo(c) != 0 || c.compareTo(b) != 0) {
            message = "traingle is usual";
        }
        System.out.print(message);
        return message;
    }
}
