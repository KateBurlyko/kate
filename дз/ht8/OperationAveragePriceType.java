package ht8;

import ht8.Operation;

import java.util.ArrayList;


import java.util.Scanner;

/**
 * considers average prise for type which input user
 */
public class OperationAveragePriceType extends Operation {

    /**
     * get quantity and prise for type which input user from ArrayList and considers average prise
     *
     * @param products array of data which input by user
     * @return true if method do
     */
    public boolean operation(ArrayList products, String inputCommand) {
        ArrayList<Product> productList = products;
        Scanner in = new Scanner(System.in);
        double sum = 0;
        double qua = 0;
        String s1 = "average price ";
        String[] parts = inputCommand.split(" ");
        if (inputCommand.equals("")) {
            for (int i = 0; i < productList.size(); i++) {
                if (parts[3].equals(productList.get(i).getType())) {
                    sum = sum + productList.get(i).getPrice();
                    qua = qua + productList.get(i).getQuantity();
                    System.out.print("Average price for input type: " + sum / qua);
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
