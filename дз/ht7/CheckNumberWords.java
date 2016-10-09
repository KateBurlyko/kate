package ht6;

/**
 * Checks line on contains more than 5 words.
 */
public class CheckNumberWords {

    /**
     * The method counts words in line.
     *
     * @param line string which user input.
     */
    public void checkNumberWords(String line) {
        String wor[] = line.split(" ");
        if (wor.length >= 6) {
            System.out.println("String corresponds to rule 3: contains more than 5 words");
        } else {
        }
    }
}
