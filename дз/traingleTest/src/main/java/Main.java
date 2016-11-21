import java.math.BigDecimal;
import java.util.InputMismatchException;

/**
 * initialized variables and call methods accordin to the task
 */
public class Main {

    /**
     * @param args - conveys the name of the variable returns the value of a variable
     */
    public static void main(String[] args) {
        Input in = new Input();
        Traingl tryi = new Traingl();
        try {
            BigDecimal a = in.inputs();
            BigDecimal b = in.inputs();
            BigDecimal c = in.inputs();
            tryi.tri(a, b, c);
        } catch (InputMismatchException e) {
            System.out.print("error");
            return;
        }
        catch (InputExec e) {
            System.out.print(e.getMessage());
            return;
        }


    }
}
