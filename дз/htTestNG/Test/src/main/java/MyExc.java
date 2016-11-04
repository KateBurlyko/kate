/**
 * class which generate user exception
 * extends from Exception
 */
public class MyExc extends Throwable {

    /**
     * constructor initializes exception message
     *
     * @param message Exception message
     */
    public MyExc(String message) {
        super(message);
    }
}
