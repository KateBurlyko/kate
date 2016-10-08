package ht6;

/**
 * checks line on rule 3:contains more than 5 words
 */
public class Threerule {

    /**
     * the method counts words in line
     *
     * @param a - string which user input
     */
    public void tree(String a) {
        String parts[] = a.split("\\p{Punct}");
        if (parts.length > 5) {
            System.out.println("String corresponds to rule 3: contains more than 5 words");
        } else {
        }
    }
}
