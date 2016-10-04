package ht5;

/**
 * it has method tri
 */
public class Traingl {
    /* method calculates the shape of figure
   *
   * @param a first side
   * @param b second side
   * *@param c second side
   * @return nothing
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
