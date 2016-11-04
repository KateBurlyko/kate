

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
    public String tri(double a, double b, double c) {
        String message = " ";
        if (Double.isNaN(a / 0) || Double.isNaN(b / 0) || Double.isNaN(c / 0) ||
                Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c) ||
                (a + b) < c || (b + c) < a || (c + a) < b) {
            message = "This task does not have roots";
        } else if (a == b && a == c && c == b) {
            message = "traingl is equilateral";
        } else if (a == b || a == c || c == b) {
            message = "traingle is isosceles";
        } else if (a != b || a != c || c != b) {
            message = "traingle is usual";
        }
        System.out.print(message);
        return message;
    }
}
