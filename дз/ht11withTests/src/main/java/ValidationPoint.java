import java.util.ArrayList;

/**
 * compare coordinates of checkpoints
 * check number of checkpoint
 */
public class ValidationPoint {

    /**
     * compare coordinates of first and last checkpoints and if they the same call about it
     * check number of checkpoints
     *
     * @param coordin arraylist with objects in which are stored of coordinates of checkpoints
     * @throws MyExc -user exception
     */
    public void validate(ArrayList<Coordinata> coordin) throws MyExc {
        Coordinata[] xSum = new Coordinata[coordin.size()];
        for (int i = 0; i < xSum.length; i++) {
            xSum[i] = coordin.get(i);
        }
        double xs = (xSum[0].getX() - xSum[(xSum.length) - 1].getX());
        double ys = (xSum[0].getY() - xSum[(xSum.length) - 1].getY());
        int com = Double.compare(xs, ys);
        if (com == 0) throw new MyExc("incorrect route");
        {
        }
        if (1 == coordin.size()) throw new MyExc("incorrect route");
        {
        }
    }
}
