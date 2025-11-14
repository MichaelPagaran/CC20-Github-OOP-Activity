import java.util.Scanner;
/**
 * Demonstration: A simple program that displays positive affirmations to the user.
 *
 * Author: Louiza Beatrice L. Lim
 *
 * Description:
 * This program allows the user to view motivational affirmations. The user can choose
 * between a cycling list of affirmations or randomly selected ones, and refresh them
 * as many times as they like. It provides an easy and encouraging way to receive
 * uplifting messages.
 */


public class DailyAffirmationDisplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AffirmationSource source;

        System.out.println("Choose affirmation mode: (1) Daily cycle (2) Random)");
        int choice = sc.nextInt();

        source = (choice == 1) ? new StaticAffirmationSource() : new RandomAffirmationSource();

        char again;
        do {
            source.displayAffirmation();
            System.out.print("Refresh for a new one? (y/n): ");
            again = sc.next().charAt(0);
        } while (again == 'y' || again == 'Y');

        System.out.println("Have a wonderful day! 🌸");
        sc.close();
    }
}
