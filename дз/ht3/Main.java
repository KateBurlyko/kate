// in this class work calculator

public class Main {
    public static void main(String[] args) {


        Operacii operacii = new Operacii(); //create the object of class Operacii

        double a = Double.parseDouble(args[0]); //"convert" from string to double
        double b = Double.parseDouble(args[1]); //"convert" from string to double

        System.out.println("Summa: " + operacii.sum(a, b)); //output summy

        System.out.println("Raznost: " + operacii.raz(a, b));//output raznost

        System.out.println("Umnozenie: " + operacii.umn(a, b));//output umnozenie

//on the basis of test prints to zero error or the result of the division
        Operacii prover = new Operacii();
        if (Proverka.prov(a, b)) {
            System.out.println("Delenie: " + operacii.del(a, b));
        } else {
            System.out.println("Error!");
        }

    }
}
