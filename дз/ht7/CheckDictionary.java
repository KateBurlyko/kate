package ht6;

/**
 * Checks line on rule 4: contains word from dictionary.
 */
public class CheckDictionary {

    /**
     * The method checks string by comparing elements of arrays. one array with word from ductionary
     * second array with words which input user.
     *
     * @param line string which user input.
     */
  public void checkDictionary(String line) {
        String[] dict = {"cat", "dog", "hedgehog", "turtle", "rabbit"};
        String[] parts = line.split("[,.:; !?]");
        for (int i = 0; i < parts.length; i++) {
            for(int j = 0; j < dict.length; j++)
            if ( parts[i].equals(dict[j])) {
                    System.out.println("String corresponds to rule 4: contains word from dictionary");
                } else {
                }
        }
   }
}
