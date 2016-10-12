package ht8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * In this class inputs: type of product, name of type, quantity of name, cost of name
 */
public class InputProduct {
    ArrayList<Product> products = new ArrayList<>();

    /**
     * inputs data and write in arraylist
     *
     * @param args conveys the name of the variable returns the value of a variable.
     */
    public void inputProduct(String[] args) {
        Scanner in = new Scanner(System.in);

        // System.out.print("want to input product?");
        String y = "yes";
        while (y.equals("yes")) {
            Product products = new Product();
            System.out.print("Enter type of product ");
            String typ = in.nextLine();
            while (typ.isEmpty()) {
                System.out.print("Enter type of product ");
                typ = in.nextLine();
            }
            products.add(typ);
            System.out.print("Enter name of type ");
            String nam = in.nextLine();
            while (nam.isEmpty()) {
                System.out.print("Enter name of type ");
                nam = in.nextLine();
            }
            products.add(nam);
            try {
                System.out.print("Enter quantity of name ");
                int q = in.nextInt();
                products.add(q);

                System.out.print("Enter cost of name ");
                int c = in.nextInt();
                in.nextLine();
                products.add(c);

            } catch (java.util.InputMismatchException e) {
                System.out.print("wrong data");
                System.exit(5);
            }
            System.out.print("want to input product? input yes or no ");
            y = in.nextLine();
        }

    }
}

