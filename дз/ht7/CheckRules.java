package ht7;

/**
 * The method check rules
 */
public class CheckRules {

    /**
     * The method calls other metods in order to check rules
     *
     * @param line user input from keyboard.
     */
    public void chekRules(String line) {

        CheckNoNumber on = new CheckNoNumber();
        on.check(line);

        CheckNoLetters tw = new CheckNoLetters();
        tw.check(line);

        CheckNumberWords tr = new CheckNumberWords();
        tr.check(line);

        CheckDictionary fo = new CheckDictionary();
        fo.check(line);
    }
}
