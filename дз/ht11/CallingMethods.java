import java.util.ArrayList;

/**
 * Created by Janek on 27-окт-16.
 */
public class CallingMethods {
    public void methods(){
        ArrayList<Coordinata> coordin = new ArrayList<Coordinata>();
        ArrayList<String> koord = new ArrayList<String>();

        ReadFile rea = new ReadFile();
        rea.readFile(koord);
        GetCoordinatas gd = new GetCoordinatas();
        gd.getCoordinatas(koord, coordin);
        ValidationPoint vp = new ValidationPoint();
        vp.validate(coordin);
        CountDistance cd = new CountDistance();
        cd.countDistance(coordin);
    }
}
