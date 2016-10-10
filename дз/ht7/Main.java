package ht7;

import java.util.Scanner;

/**
 * Entry point in the program.
 */
public class Main {

    /**
     * Scanner line and call method in which rules are testing.
     *
     * @param args conveys the name of the variable returns the value of a variable.
     */
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        line = in.nextLine();

        CheckRules ch = new CheckRules();
        ch.chekRules(line);
    }
}
