package ht8;

import java.util.ArrayList;

/**
 * considers average price
 */
public class OperationAveragePrice extends Operation {

    /**
     * get quantity and prise from ArrayList and considers average prise
     *
     * @param products array of data which input by user
     * @return true if method do
     */
    public boolean operation(ArrayList products, String inputCommand) {
        ArrayList<Product> productList = products;
        double sum = 0;
        double qua = 0;
        String s1 = "average price";
        if (inputCommand.equals(s1)) {
            for (int i = 0; i < productList.size(); i++) {

                sum = sum + productList.get(i).getPrice();
                qua = qua + productList.get(i).getQuantity();
            }


            System.out.println("The average prise of all goods is " + sum / qua);
            return true;
        } else {
            return false;
        }
    }
}
