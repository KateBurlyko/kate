package ht6;

/**
 * Checks line on rule 1: no numbers.
 */
public class CheckNoNumber {

    /**
     * The method checks numbers on line and if there are no numbers say about it.
     *
     * @param a - string which user input.
     */
    public void checkNoNumber(String a) {
        if (a.matches("\\D+")) {
            System.out.println("String corresponds to rule 1: no numbers");
        } else {
        }
    }
}
