package ht6;

/**
 *
 */
public class Checking {

    /**
     *
     * @param a
     */
    void check(String a) {

        Onerule on = new Onerule();
        on.one(a);

        Tworule tw = new Tworule();
        tw.two(a);

        Threerule tr = new Threerule();
        tr.tree(a);

        Fourrule fo = new Fourrule();
        fo.four(a);

        
    }

}
