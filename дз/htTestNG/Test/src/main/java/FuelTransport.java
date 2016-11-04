/**
 * base class for fuel type of transport
 * contain field time and countTravel
 */
public class FuelTransport implements WayToTravel {

    CountDistance cd = new CountDistance();
    public static double time;
    public static double countTravel;

    /**
     * @return traveling time
     */
    double getTime() {
        return time;
    }

    /**
     * @return count of traveling
     */
    double getCountTravel() {
        return countTravel;
    }

    /**
     * count traveling time
     *
     * @param SPEED value of speed in behavior
     */
    public double timeToTravel(double SPEED) {
        time = (cd.getDistance() / SPEED);
        if (Double.isNaN(time) || Double.isInfinite(time) || time < 0 || SPEED < 0)
            throw new ArithmeticException("wrong data for transport");
        return time;
    }

    /**
     * count cost of traveling
     *
     * @param SPEED      value of speed in behavior
     * @param PASSENGERS value of passengers in behavior
     * @param FUEL_CONS  value of passengers in behavior
     * @param COUNT      value of passengers in behavior
     */
    public double countTravel(double SPEED, double PASSENGERS, double FUEL_CONS, double COUNT) {
        countTravel = ((FUEL_CONS * SPEED * COUNT) / (100 * cd.getDistance() * PASSENGERS));
        if (Double.isNaN(countTravel) || Double.isInfinite(countTravel) || countTravel < 0
                || PASSENGERS < 0 || FUEL_CONS < 0 || SPEED < 0 || COUNT < 0)
            throw new ArithmeticException("wrong data for transport");
        return countTravel;
    }
}
