package qqqq;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
			
          Scanner in = new Scanner(System.in);
          System.out.print("Input first number: ");
          double a = in.nextDouble();
          System.out.print("Input second number: ");
          double b = in.nextDouble();	
			 
              Operacii summa = new Operacii();
              System.out.println("Summa: " + summa.sum(a, b)); 	
			 
              Operacii raznost = new Operacii();
              System.out.println("Raznost: " + raznost.raz(a, b)); 	
			 
              Operacii umnoz = new Operacii();
              System.out.println("Umnozenie: " + umnoz.umn(a, b)); 	
			 
              Proverka prover = new Proverka();
              System.out.println("Delenie: " + prover.prov(a, b)); 	
     }
  }
