import java.util.InputMismatchException;

/**
 * initialized variables and call methods accordin to the task
 */
public class Main {

    /**
     * @param args - conveys the name of the variable returns the value of a variable
     */
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double c = 0;
        try {
            Input in = new Input();
            in.inputs(a, b, c);
        } catch (InputMismatchException e) {
            System.out.print("error");
            return;
        }

    }
}
