package ht7;

/**
 * Checks line on contains more than 5 words.
 */
public class CheckNumberWords extends Builder {

    /**
     * The method counts words in line.
     *
     * @param line string which user input.
     * @return result of rule
     */
    public boolean check(String line) {
        String wor[] = line.split("[\\s\\p{Punct}]+");
        if (wor.length >= 6) {
            System.out.println("String corresponds to rule 3: contains more than 5 words");
            return true;
        } else {
            return false;
        }
    }
}
