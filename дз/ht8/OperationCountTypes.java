package ht8;

import java.util.ArrayList;

/**
 * consider quantity of types which input user
 */
public class OperationCountTypes extends Operation {

    /**
     * compare types and input quantity
     *
     * @param products array of data which input by user
     * @return true if method do
     */
    public boolean operation(ArrayList products, String inputCommand) {
        if (inputCommand.equals("count types")) {
            System.out.print("The quantity of types is " + products.size());
            return true;
        } else {
            return false;
        }
    }
}
