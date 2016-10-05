package ht4;

/**
 * solves equation
 */
public class Decision {
    /**
     * counting roots of task
     *
     * @param a first number
     * @param b second number
     * @param c second number
     */
    public void decision(double a, double b, double c) {
        double d = b * b - 4 * a * c;

        if (d < 0) {
            System.out.println("This task does not have roots");
            return;
        }

        if ((1. / a) == Double.POSITIVE_INFINITY || (1. / a) == Double.NaN) {
            System.out.print("This task does not have roots");
            return;
        }
        if ((1. / d) == Double.POSITIVE_INFINITY || (1. / d) == Double.NaN) {
            double x1;
            x1 = (-1 * b) / (2 * a);
            System.out.println("root: x1=x2= " + x1);
            return;
        } else {
            double x1 = ((-1 * b) + Math.sqrt(d)) / (2 * a);
            double x2 = ((-1 * b) - Math.sqrt(d)) / (2 * a);
            System.out.println("roots: x1= " + x1 + ",   " + "x2= " + x2);
            return;
        }


    }
}

