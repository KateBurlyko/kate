/**
 * class which generate user exception
 * extends from Exception
 */
public class InputExec extends Throwable {

    /**
     * constructor initializes exception message
     *
     * @param message Exception message
     */
    public InputExec(String message) {
        super(message);
    }
}
