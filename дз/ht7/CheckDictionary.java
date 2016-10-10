package ht7;

/**
 * Checks line on rule 4: contains word from dictionary.
 */
public class CheckDictionary extends Builder {

    /**
     * The method checks string by comparing elements of arrays. one array with word from ductionary
     * second array with words which input user.
     *
     * @param line string which user input.
     * @return result of rule
     */
    public boolean check(String line) {
        int containe = 0;
        String[] dict = {"cat", "dog", "hedgehog", "turtle", "rabbit"};
        String[] parts = line.split("[\\s\\p{Punct}]+");
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < dict.length; j++)
                if (parts[i].equals(dict[j])) {

                    containe++;
                } else {
                }
        }
        if (containe != 0) {
            System.out.println("String corresponds to rule 4: contains word from dictionary");
            return true;
        } else {
            return false;
        }
    }
}
