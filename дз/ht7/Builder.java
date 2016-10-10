package ht7;

/**
 * bulder is the superclass
 */
abstract class Builder {

    /**
     * abstract method for rules
     *
     * @param line inputs.
     * @return result of rules
     */
    public abstract boolean check(String line);

}
