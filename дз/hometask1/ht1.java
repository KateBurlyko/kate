public class ht1 {
//output arguments in reverse order
 public static void main(String[] args) {

    for(int i = args.length - 1; i >= 0; i--) {

        System.out.println("Argument " + i + " = " + args[i]);

      }
   }
}