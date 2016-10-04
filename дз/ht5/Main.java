package ht5;

import java.util.Scanner;

/*
this class has method main
 */

public class Main {
    /*
class main inputs number and  call method decision, catch exeption
*/
    public static void main(String[] args) {
        double a;
        double b;
        double c;

        Scanner in = new Scanner(System.in);
        try {
            //catch exeption
            do {
                System.out.print("input first side");
                a = in.nextDouble();
                System.out.print("input second side");
                b = in.nextDouble();
                System.out.print("input third side");
                c = in.nextDouble();
            }
            while (a < 0 || c < 0 || b < 0);
            Traingl tra = new Traingl();
            tra.tri(a, b, c);
        } catch (java.util.InputMismatchException e) {


            System.out.print("wrong data"); //create class object
            System.exit(5); //call the method decision
        }
    }
}
