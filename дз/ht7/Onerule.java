package ht6;

/**
 * checks line on rule 1: no numbers
 */
public class Onerule {

    /**
     * the method checks numbers on line and if there are no numbers say about it
     *
     * @param a - string which user input
     */
    public void one(String a) {
        if (a.matches("\\D+")) {
            System.out.println("String corresponds to rule 1: no numbers");
        } else {
        }
    }
}
