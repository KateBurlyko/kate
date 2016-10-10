package ht7;

import java.util.Scanner;

/**
 * Checks line on rule 2:contains only numbers.
 */
public class CheckNoLetters extends Builder {

    /**
     * The method checks letters on line and if there are only numbers say about it.
     *
     * @param line string which user input.
     * @return result of rule
     */
    public boolean check(String line) {
        Scanner scanner = new Scanner(line);

        if (scanner.hasNextInt() && line.matches(" ")) {
            System.out.println("String corresponds to rule 2: contains only numbers");
            return true;
        } else {
            return false;
        }
    }
}
