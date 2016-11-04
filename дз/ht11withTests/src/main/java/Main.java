
/**
 * entry point of program
 */
public class Main {

    /**
     * method calls the method  " CallingMethods" in which get checkpoints and considers distanse
     * and calls methods which corresponding way to trevel
     *
     * @param args conveys the name of the variable returns the value of a variable.
     * @throws MyExc -user exception
     */
    public static void main(String[] args) throws MyExc {
        CallingMethods cm = new CallingMethods();
        cm.methods();
        try {
            Bus b = new Bus();
            b.operation();
            Car c = new Car();
            c.car();
            Bycikle by = new Bycikle();
            by.bycicle();
            OnFoot of = new OnFoot();
            of.onFoot(5,1,0,0);
        } catch (ArithmeticException e) {
            System.out.print(e.getMessage());
        }
    }
}
