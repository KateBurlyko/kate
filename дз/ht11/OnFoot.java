/**
 * count traveling time and distance
 * contain fields with values for calculation
 */
public class OnFoot implements WayToTravel {
    private double SPEED = 0;
    private double PASSENGERS = 0;
    private double FUEL_CONS = 0;
    private double COUNT = 0;
    public static double time;
    public static double countTravel;
    CountDistance cd = new CountDistance();

    /**
     * getter for traveling time
     *
     * @return value of traveling time
     */
    double getTimes() {
        return time;
    }

    /**
     * getter for traveling count
     *
     * @return return value of traveling count
     */
    double getCountTravels() {
        return countTravel;
    }

    /**
     * count time for foot travel
     *
     * @param SPEED      value of speed in behavior
     * @param PASSENGERS value of passengers in behavior
     * @param FUEL_CONS  value of passengers in behavior
     * @param COUNT      value of passengers in behavior
     */
    public void timeToTravel(double SPEED, double PASSENGERS, double FUEL_CONS, double COUNT) {
        time = (cd.getDistance() / SPEED);
    }

    /**
     * count cost for foot travel
     *
     * @param SPEED      value of speed in behavior
     * @param PASSENGERS value of passengers in behavior
     * @param FUEL_CONS  value of passengers in behavior
     * @param COUNT      value of passengers in behavior
     */
    public void countTravel(double SPEED, double PASSENGERS, double FUEL_CONS, double COUNT) {
        countTravel = ((FUEL_CONS * SPEED * COUNT) / (100 * cd.getDistance() * PASSENGERS));
    }

    /**
     * calls methods for counting time and cost
     * output information about travel
     */
    public void onFoot() {
        SPEED = 5;
        PASSENGERS = 1;
        FUEL_CONS = 0;
        COUNT = 0;
        timeToTravel(SPEED, PASSENGERS, FUEL_CONS, COUNT);
        countTravel(SPEED, PASSENGERS, FUEL_CONS, COUNT);
        System.out.println("stat for foot: " + "\n time " + getTimes() + " hours" + "\n count " + getCountTravels() + " USD");
    }
}
