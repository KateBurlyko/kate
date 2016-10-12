package ht8;

import ht8.Operation;
import ht8.Product;

import java.util.ArrayList;


/**
 * count overal type
 */
public class OperationCountAll extends Operation {

    /**
     * get name of type and considers them all
     *
     * @param products array of data which input by user
     * @return true if method do
     */
    public boolean operation(ArrayList products, String inputCommand) {
        ArrayList<Product> productList = products;
        double sum = 0;
        if (inputCommand.equals("count all")) {
            for (int i = 0; i < products.size(); i++) {
                sum = sum + productList.get(i).getQuantity();
            }
            System.out.println("The quantity of all goods is " + sum);
            return true;
        } else {
            return false;
        }
    }
}
