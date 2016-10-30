import java.util.ArrayList;

/**
 *
 */
public class CallingMethods {

    /**
     *
     * @throws MyExc
     */
    public void methods() throws MyExc {
        ArrayList<Coordinata> coordin = new ArrayList<Coordinata>();
        ArrayList<String> koord = new ArrayList<String>();

        ReadFile rea = new ReadFile();
        rea.readFile(koord);
        GetCoordinatas gd = new GetCoordinatas();
        gd.getCoordinatas(koord, coordin);
        try {
            ValidationPoint vp = new ValidationPoint();
            vp.validate(coordin);
            CountDistance cd = new CountDistance();
            cd.countDistance(coordin);
        } catch (MyExc e){
            System.out.println(e.getMessage());
        }
    }
}
