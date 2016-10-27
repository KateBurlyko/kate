import java.util.ArrayList;

/**
 * get coordinates of checkpoints
 */
public class GetCoordinatas {

    /**
     * get coordinates and put them in arraylist
     *
     * @param koord   arraylist with value of string from file
     * @param coordin arraylist with objects in which are stored of coordinates of checkpoints
     */
    public void getCoordinatas(ArrayList<String> koord, ArrayList<Coordinata> coordin) {
        String[] output = new String[koord.size()];
        ArrayList<Coordinata> coorList = coordin;
        double x = 0;
        double y = 0;
        double[] xy = new double[2];
        for (int i = 0; i < koord.size(); i++) {
            String[] xyString;
            output[i] = koord.get(i);
            xyString = output[i].split(" ");
            for (int a = 0; a < 2; a++) {
                xy[a] = Double.parseDouble(xyString[a]);
                for (int j = 0; j < xy.length; j++) {
                    x = xy[0];
                    for (int k = 1; k < xy.length; k++) {
                        y = xy[1];
                    }
                }
            }
            coorList.add(new Coordinata(x, y));
        }
//        System.out.print(coordin);
    }
}
