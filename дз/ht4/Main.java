package ht4;

import java.util.Scanner;
/*
this class has method main
 */

public class Main {
    /*
    class main inputs number and  call method decision, catch exeption
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a;
        double b;
        double c;

        try {
            //catch exeption
            do {
                System.out.print("Input a:");
                a = in.nextDouble();
                System.out.print("Input b:");
                b = in.nextDouble();
                System.out.print("Input c:");
                c = in.nextDouble();
            }
            while (a < Double.MIN_VALUE || a > Double.MAX_VALUE ||
                    b < Double.MIN_VALUE || b > Double.MAX_VALUE ||
                    c < Double.MIN_VALUE || c > Double.MAX_VALUE);


            Decision decis = new Decision(); // create class object
            decis.decision(a, b, c); //call the method decision
        } catch (java.util.InputMismatchException e) {
            System.out.print("wrong data");
            System.exit(5);
        }
    }
}
