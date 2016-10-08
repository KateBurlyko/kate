package ht6;

/**
 *
 */
public class Fourrule extends Checking {

    /**
     *
     * @param a
     */
    void four(String a) {
        String[] dict = {"cat", "dog", "hedgehog", "turtle", "rabbit"};
        for (int i = 0; i < dict.length; i++) {
            if (a.contains(dict[i])) {
                System.out.println("String corresponds to rule 4: contains word from dictionary");
            } else {
            }
        }
    }
}
