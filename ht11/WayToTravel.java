/**
 * interface describes descendants of behavior
 */
public interface WayToTravel {

    /**
     * count travel time
     *
     * @param SPEED      value of speed in behavior
     * @param PASSENGERS value of passengers in behavior
     * @param FUEL_CONS  value of passengers in behavior
     * @param COUNT      value of passengers in behavior
     */
    void timeToTravel(double SPEED, double PASSENGERS, double FUEL_CONS, double COUNT);
}
