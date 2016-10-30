/**
 * count traveling time and distance
 * contain fields with values for calculation
 */
public class Bycikle implements WayToTravel {
    private double SPEED;
    private double PASSENGERS;
    private double FUEL_CONS;
    private double COUNT;

    public static double time;
    public static double countTravel;

    /**
     * getter for traveling time
     *
     * @return value of traveling time
     */
    double getTime() {
        return time;
    }

    /**
     * getter for traveling count
     *
     * @return return value of traveling count
     */
    double getCountTravel() {
        return countTravel;
    }

    CountDistance cd = new CountDistance();

    /**
     * count time for bicycle travel
     *
     * @param SPEED value of speed in behavior
     */
    public double timeToTravel(double SPEED) {
        time = (cd.getDistance() / SPEED);
        return time;
    }

    /**
     * count cost for bicycle travel
     *
     * @param SPEED      value of speed in behavior
     * @param PASSENGERS value of passengers in behavior
     * @param FUEL_CONS  value of passengers in behavior
     * @param COUNT      value of passengers in behavior
     */
    public double countTravel(double SPEED, double PASSENGERS, double FUEL_CONS, double COUNT) {

        countTravel = ((FUEL_CONS * SPEED * COUNT) / (100 * cd.getDistance() * PASSENGERS));
        return countTravel;
    }

    /**
     * calls methods for counting time and cost
     * output information about travel
     */
    public void bycicle() {
        SPEED = 20;
        PASSENGERS = 1;
        FUEL_CONS = 0;
        COUNT = 0;
        timeToTravel(SPEED);
        countTravel(SPEED, PASSENGERS, FUEL_CONS, COUNT);
        if (Double.isNaN (getCountTravel())) {
            System.out.println("stat for bicykle: " + "\n time " + getTime() + " hours" + "\n count " + 0 + " USD");
        } else {
            System.out.println("stat for bicykle: " + "\n time " + getTime() + " hours" + "\n count " + getCountTravel() + " USD");
        }
    }
}
