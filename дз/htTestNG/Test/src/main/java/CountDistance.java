import java.util.ArrayList;

import static java.lang.System.out;

/**
 * count traveling distanse
 * contain field distanse
 */
public class CountDistance {
    public double distance;

    /**
     * count and summarizes distanse between checkpoints
     *
     * @return value of traveling distance
     */
    double getDistance() {
        return distance;
    }

    /**
     * get coordinates fron arraylist and count all distanse
     *
     * @param coordin arraylist with objects in which are stored of coordinates of checkpoints
     * @return value of distanse
     * @throws MyExc -user exception
     */
    public double countDistance(ArrayList<Coordinata> coordin) throws MyExc {
        distance = 0.0;
        if (coordin.size() == 1) throw new MyExc("incorrect route");
        Coordinata[] xSum = new Coordinata[coordin.size()];
        for (int i = 0; i < 2; i++) {
            xSum[i] = coordin.get(i);
        }
        double x1;
        double y1;
        for (int i = 1; i < 2; i++) {
            x1 = (xSum[i].getX() - xSum[i - 1].getX()) * (xSum[i].getX() - xSum[i - 1].getX());
            y1 = (xSum[i].getY() - xSum[i - 1].getY()) * (xSum[i].getY() - xSum[i - 1].getY());
            distance = distance + Math.sqrt(x1 + y1);
        }
        return distance;
    }
}
