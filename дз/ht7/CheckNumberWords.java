package ht6;

/**
 * Checks line on rule 3:contains more than 5 words.
 */
public class CheckNumberWords {

    /**
     * The method counts words in line.
     *
     * @param a - string which user input.
     */
    public void checkNumberWords(String a) {
        String parts[] = a.split("\\p{Punct}");
        if (parts.length > 5) {
            System.out.println("String corresponds to rule 3: contains more than 5 words");
        } else {
        }
    }
}
