package programs.gella;

import java.util.Scanner;
import java.util.Random;
import ProgramInterface;

// Mini Love Calculator Program
public class MiniLoveCalculator implements ProgramInterface {

    @Override
    public String getName() {
        return "Mini Love Calculator";
    }

    @Override
    public String getDescription() {
        return "A program that calculates love compatibility between two names using randomization.";
    }

    @Override
    public String getAuthor() {
        return "Gella";
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("❤️ Welcome to the Mini Love Calculator! ❤️");
        System.out.print("Enter your name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter your partner's name: ");
        String name2 = sc.nextLine();

        // Generate a random love score between 0 and 100
        int loveScore = random.nextInt(101);

        System.out.println("\n💖 Love compatibility for " + name1 + " and " + name2 + " is: " + loveScore + "% 💖");

        sc.close();
    }
}
