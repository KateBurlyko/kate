package ht6;

/**
 * checks line on rule 4: contains word from dictionary
 */
public class Fourrule {

    /**
     * the method checks string by comparing elements of arrays. one array with word from ductionary
     * second array with words which input user
     *
     * @param a - string which user input
     */
    public void four(String a) {
        String[] dict = {"cat", "dog", "hedgehog", "turtle", "rabbit"};
        String parts[] = a.split("\\p{Punct}");
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < parts.length; j++) {
                if (i == j) {
                    System.out.println("String corresponds to rule 4: contains word from dictionary");
                } else {
                }
            }
        }
    }
}
