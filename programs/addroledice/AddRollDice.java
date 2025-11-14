package programs.addrolldice;

import java.util.Random;
import java.util.Scanner;
import ProgramInterface;

/*
 * 🎲 Add & Roll Dice Program
 * --------------------------
 * This program simulates rolling two dice multiple times.
 * It displays the result of each roll and the total sum.
 *
 * Author: Denz Macasero
 * Description: A simple random dice roller that lets the user choose
 *              how many times to roll the dice.
 */

public class AddRollDice implements ProgramInterface {

    public String getName() { 
        return "Add & Roll Dice"; 
    }

    public String getDescription() { 
        return "Rolls two dice and displays their values and total."; 
    }

    public String getAuthor() { 
        return "Denz Macasero"; 
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("🎲 Welcome to the Add & Roll Dice Program!");
        System.out.print("How many times do you want to roll the dice? ");
        int rolls = sc.nextInt();

        for (int i = 1; i <= rolls; i++) {
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int total = die1 + die2;
            System.out.println("Roll " + i + ": Die 1 = " + die1 + ", Die 2 = " + die2 + ", Total = " + total);
        }

        System.out.println("Thanks for playing!");
    }
}
