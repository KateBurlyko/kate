package ht5;

import java.util.Scanner;

/**
 * entry and validation variables
 */
public class Input {

    /**
     * method reads from the keybords the values of variables and checks the entered data
     * @param a - first side
     * @param b - second side
     * @param c - third side
     */
    void inputs(double a, double b, double c) {
        Scanner in = new Scanner(System.in);
        try {
            do {
                System.out.print("input first side: ");
                a = in.nextDouble();
            }
            while (a < 0);
            do {
                System.out.print("input second side: ");
                b = in.nextDouble();
            }
            while (b < 0);
            do {
                System.out.print("input third side: ");
                c = in.nextDouble();
            }
            while (c < 0);
            Traingl tra = new Traingl();
            tra.tri(a, b, c);
        } catch (java.util.InputMismatchException e) {


            System.out.print("wrong data");
            System.exit(5);
        }
    }
}
