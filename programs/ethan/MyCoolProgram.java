package programs.ethan;

import java.util.Scanner;
import core.ProgramInterface;
import java.util.Scanner;

/**
*Simple square root finder
*This program automatically calculates the square root of your number.
*Author: Ethan Kyle C. Anggot
*Description: calculates the square root of a number
*/








// 🧩 TEMPLATE: Copy this to your own folder and modify values.
public class MyCoolProgram implements ProgramInterface {

    public String getName() { return "pang square root"; }
    public String getDescription() { return "determines the square root of your choice of number"; }
    public String getAuthor() { return "Ethan"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! This is your custom program.");
        // Add your logic here


          Scanner input = new Scanner(System.in);

     
        System.out.print("Enter a number to find its square root: ");
        double number = input.nextDouble();

      
        if (number < 0) {
            System.out.println("Error: Cannot calculate the square root of a negative number.");
        } else {
            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is " + squareRoot);
        }

     
        input.close();
    }
}
