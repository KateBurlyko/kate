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
     * @param SPEED value of speed in behavior
     */
    public double timeToTravel(double SPEED) {
        time = (cd.getDistance() / SPEED);
        if (Double.isInfinite(time) || Double.isNaN(time) || time < 0 || SPEED < 0)
            throw new ArithmeticException("wrong data for foot");
        return time;
    }

    /**
     * count cost for foot travel
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
            throw new ArithmeticException("wrong data for foot");
        return countTravel;
    }

    public void output() {

    }

    /**
     * calls methods for counting time and cost
     * output information about travel
     */
    public void onFoot(double SPEED, double PASSENGERS, double FUEL_CONS, double COUNT) throws ArithmeticException {
        //  SPEED = -5;
//        PASSENGERS = 1;
//        FUEL_CONS = 0;
//        COUNT = 0;
        timeToTravel(-5);
        countTravel(5, 1, 0, 0);
        System.out.println("stat for foot: " + "\n time " + getTimes() + " hours" + "\n count " + getCountTravels() + " USD");
    }
}
