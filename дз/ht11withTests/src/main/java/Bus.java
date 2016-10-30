/**
 * count traveling time and distance
 */
public class Bus extends FuelTransport implements WayToTravel {

    /**
     * calls methods for counting time and cost
     * output information about travel
     */
    public void operation() {
        FuelTransport ft = new FuelTransport();
        double SPEED = 60;
        double PASSENGERS = 37;
        double FUEL_CONS = 10;
        double COUNT = 0.50;
        timeToTravel(SPEED);
        countTravel(SPEED, PASSENGERS, FUEL_CONS, COUNT);
        if (Double.isInfinite(ft.getCountTravel())) {
            System.out.println("stat for bus: " + "\n time " + ft.getTime() + " hours" + "\n count " + 0 + " USD");
        } else {
            System.out.println("stat for bus: " + "\n time " + ft.getTime() + " hours" + "\n count " + ft.getCountTravel() + " USD");
        }
    }
}
