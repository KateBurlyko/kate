package ht8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * entry point of program.
 */
public class Main {

    /**
     * @param args conveys the name of the variable returns the value of a variable.
     */
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        InputProduct inp = new InputProduct();
        inp.inputProduct(args);
        String inputCommand;
        do {
            System.out.print("input command: ");
            inputCommand = in.nextLine();
            AddOperation opera = new AddOperation().add(new OperationAveragePrice())
                                                   .add(new OperationAveragePriceType())
                                                   .add(new OperationCountAll())
                                                   .add(new OperationCountTypes());
        } while (inputCommand.equals("exit"));
    }
}
