/**
 * count traveling time and distance
 */
public class Car extends FuelTransport implements WayToTravel {

    /**
     * calls methods for counting time and cost
     * output information about travel
     */
    public void car() throws MyExc {
        double SPEED = 80;
        double PASSENGERS = 1;
        double FUEL_CONS = 7;
        double COUNT = 0.65;
        FuelTransport ft = new FuelTransport();
        timeToTravel(SPEED);
        countTravel(SPEED, PASSENGERS, FUEL_CONS, COUNT);
        System.out.println("stat for car: " + "\n time " + ft.getTime() + " hours" + "\n count " + ft.getCountTravel() + " USD");
    }
}
