package ht6;

/**
 * Checks line on rule 2:contains only numbers.
 */
public class CheckNoLetters {

    /**
     * The method checks letters on line and if there are no letters say about it.
     *
     * @param line - string which user input.
     */
    public void checkNoLetters(String line) {
        if (line.matches("\\d+")) {
            System.out.println("String corresponds to rule 2: contains only numbers");
        } else {
        }
    }
}
