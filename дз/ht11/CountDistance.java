import java.util.ArrayList;

/**
 * count traveling distanse
 * contain field distanse
 */
public class CountDistance {

    public static double distance;

    /**
     * count and summarizes distanse between checkpoints
     *
     * @return value of traveling distance
     */
    double getDistance() {
        return distance;
    }

    public void countDistance(ArrayList<Coordinata> coordin) {
        Coordinata[] xSum = new Coordinata[coordin.size()];
        Coordinata[] ySum = new Coordinata[coordin.size()];
        for (int i = 0; i < xSum.length; i++) {
            xSum[i] = coordin.get(i);
        }
        for (int i = 0; i < ySum.length; i++) {
            ySum[i] = coordin.get(i);
        }
        double x1 = 0;
        double y1 = 0;
        for (int i = 1; i < xSum.length; i++) {
            x1 = (xSum[i].getX() - xSum[i - 1].getX()) * (xSum[i].getX() - xSum[i - 1].getX());
            for (int j = 0; j < xSum.length; j++) {
                y1 = (ySum[i].getY() - ySum[i - 1].getY()) * (ySum[i].getY() - ySum[i - 1].getY());
            }
            distance = distance + Math.sqrt(x1 + y1);
        }

    }
}
