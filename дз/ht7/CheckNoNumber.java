package ht7;

/**
 * Checks line on rule 1: no numbers.
 */
public class CheckNoNumber extends Builder {

    /**
     * The method checks numbers on line and if there are no numbers say about it.
     *
     * @param line string which user input.
     * @return result of rule
     */
    public boolean check(String line) {
        if (line.matches("\\D+")) {
            System.out.println("String corresponds to rule 1: no numbers");
            return true;
        } else {
            return false;
        }
    }
}
