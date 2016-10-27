
/**
 * entry point of program
 */
public class Main {

    /**
     * method calls the method  " CallingMethods" in which get checkpoints and considers distanse
     * and calls methods which corresponding way to trevel
     *
     * @param args conveys the name of the variable returns the value of a variable.
     */
    public static void main(String[] args) {
        CallingMethods cm = new CallingMethods();
        cm.methods();
        Bus b = new Bus();
        b.operation();
        Car c = new Car();
        c.operation();
        Bycikle by = new Bycikle();
        by.bycicle();
        OnFoot of = new OnFoot();
        of.onFoot();
    }
}
