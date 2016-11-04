

import java.util.Scanner;

/**
 * entry and validation variables
 */
public class Input {

    /**
     * method reads from the keybords the values of variables and caugth InputMismatchException
     *
     * @param a first side
     * @param b second side
     * @param c second side
     * @return message
     */
    public String inputs(double a, double b, double c) {
        Scanner in = new Scanner(System.in);
        String messa = "";
            System.out.print("input first side: ");
            a = in.nextDouble();
            System.out.print("input second side: ");
            b = in.nextDouble();
            System.out.print("input third side: ");
            c = in.nextDouble();

        Traingl tra = new Traingl();
        tra.tri(a, b, c);
        return messa;
    }
}
