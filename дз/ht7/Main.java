package ht6;

import java.util.Scanner;

/**
 * entry point in the program
 */
public class Main {

    /**
     * scanner line and call methods which test rules
     *
     * @param args - conveys the name of the variable returns the value of a variable
     */
    public static void main(String[] args) {
        String a;
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        a = in.nextLine();
        Onerule on = new Onerule();
        on.one(a);

        Tworule tw = new Tworule();
        tw.two(a);

        Threerule tr = new Threerule();
        tr.tree(a);

        Fourrule fo = new Fourrule();
        fo.four(a);
    }
}
