

/**
 * contain fiel from arraylist
 */
public class Coordinata {
    private double x;
    private double y;

    /**
     * add object with coordinates in checkpoint
     *
     * @param x coordinate of checkpoint
     * @param y coordinate of checkpoint
     */
    public Coordinata(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @return coordinate x from checkpoint
     */
    public double getX() {
        return x;
    }

    /**
     * @return coordinate y from checkpoint
     */
    public double getY() {
        return y;
    }


}
