package ht6;

/**
 * checks line on rule 2:contains only numbers
 */
public class Tworule {

    /**
     * the method checks letters on line and if there are no letters say about it
     *
     * @param a - string which user input
     */
    public void two(String a) {
        if (a.matches("\\d+")) {
            System.out.println("String corresponds to rule 2: contains only numbers");
        } else {
        }
    }
}
