package ht4;

import java.util.Scanner;

/**
 * It receives and processes the input data
 */
public class Input {

    /**
     * method reads the values and checks the entered data
     *
     * @param a - first number
     * @param b - second number
     * @param c - third number
     */
    void inputs(double a, double b, double c) {
        Scanner in = new Scanner(System.in);

        try {
            //catch exeption
            do {
                System.out.print("Input a: ");
                a = in.nextDouble();
            }
            while (a < Double.MIN_VALUE || a > Double.MAX_VALUE);
            do {
                System.out.print("Input b: ");
                b = in.nextDouble();
            }
            while (b < Double.MIN_VALUE || b > Double.MAX_VALUE);
            do {
                System.out.print("Input c: ");
                c = in.nextDouble();
            }
            while (c < Double.MIN_VALUE || c > Double.MAX_VALUE);


            Decision decis = new Decision(); // create class object
            decis.decision(a, b, c); //call the method decision
        } catch (java.util.InputMismatchException e) {
            System.out.print("wrong data");
            System.exit(5);
        }
    }
}
