package ht6;

import java.util.Scanner;

/**
 * Entry point in the program.
 */
public class Main {

    /**
     * Scanner line and call methods which test rules.
     *
     * @param args - conveys the name of the variable returns the value of a variable.
     */
    public static void main(String[] args) {
        String a;
        Scanner in = new Scanner(System.in);
        System.out.print("Input string: ");
        a = in.nextLine();

        CheckNoNumber on = new CheckNoNumber();
        on.checkNoNumber(a);

        CheckNoLetters tw = new CheckNoLetters();
        tw.checkNoLetters(a);

        CheckNumberWords tr = new CheckNumberWords();
        tr.checkNumberWords(a);

        CheckDictionary fo = new CheckDictionary();
        fo.checkDictionary(a);
    }
}
