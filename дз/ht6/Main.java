package ht6;

import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String a;
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        a = in.nextLine();

        Checking ch = new Checking();
        ch.check(a);
    }
}
