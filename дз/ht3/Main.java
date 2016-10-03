

public class Main {
    public static void main(String[] args) {


        Operacii operacii = new Operacii();

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        System.out.println("Summa: " + operacii.sum(a, b));

        System.out.println("Raznost: " + operacii.raz(a, b));

        System.out.println("Umnozenie: " + operacii.umn(a, b));

        Operacii prover = new Operacii();
        if (Proverka.prov(a, b)) {
            System.out.println("Delenie: " + operacii.del(a, b));
        } else {
            System.out.println("Error!");
        }

    }
}
