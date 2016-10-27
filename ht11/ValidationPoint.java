import java.util.ArrayList;

/**
 * compare coordinates of checkpoints
 */
public class ValidationPoint {

    /**
     * compare coordinates of first and last checkpoints and if they the same call about it
     *
     * @param coordin arraylist with objects in which are stored of coordinates of checkpoints
     */
    public void validate(ArrayList<Coordinata> coordin) {
        Coordinata[] xSum = new Coordinata[coordin.size()];
        Coordinata[] ySum = new Coordinata[coordin.size()];
        for (int i = 0; i < xSum.length; i++) {
            xSum[i] = coordin.get(i);
        }
        for (int i = 0; i < ySum.length; i++) {
            ySum[i] = coordin.get(i);
        }
        if (xSum[0].getX() == xSum[(xSum.length) - 1].getX() || ySum[0].getY() == ySum[(ySum.length) - 1].getY()) {
            System.out.print("Wrong coordinates");
            System.exit(7);
        }
    }
}