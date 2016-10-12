package ht8;

import java.util.ArrayList;

/**
 * unites all methods which doing some operation whith data which input by user
 */
public abstract class Operation {

    /**
     *
     * @param products array of data which input by user
     * @return result of rules
     */
    public abstract boolean operation(ArrayList products, String inputCommand);

}
