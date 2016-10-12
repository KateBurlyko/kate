package ht8;

import java.util.ArrayList;

/**
 * create arraylist with methods which extends from class Operation
 */
public class AddOperation {
    private ArrayList<Operation> rulesList = new ArrayList<>();

    /**
     *
     * @param operation methods which extends from class Operation
     * @return
     */
    public AddOperation add(Operation operation) {
        rulesList.add(operation);
        return this;
    }
}
