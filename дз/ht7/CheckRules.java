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
        on.checkNoNumber(line);

        CheckNoLetters tw = new CheckNoLetters();
        tw.checkNoLetters(line);

        CheckNumberWords tr = new CheckNumberWords();
        tr.checkNumberWords(line);

        CheckDictionary fo = new CheckDictionary();
        fo.checkDictionary(line);
    }
}
