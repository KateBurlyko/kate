package ht5;

/**
 *  method computes the type of figure
 */
public class Traingl {
    /**
     * It compares side and computes the type of figure
     *
     * @param a first side
     * @param b second side
     * @param c second side
     */
    public void tri(double a, double b, double c) {
        if (Double.isNaN(a / 0) || Double.isNaN(b / 0) || Double.isNaN(c / 0) ||
                Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c) ||
                (a + b) < c || (b + c) < a || (c + a) < b) {
            System.out.print("This task does not have roots");
            return;
        } else if (a == b && a == c && c == b) {
            System.out.print("traingl is equilateral");
        } else if (a == b || a == c || c == b) {
            System.out.print("traingle is isosceles");
        } else if (a != b || a != c || c != b) {
            System.out.print("traingle is usual");
        }

    }
}
