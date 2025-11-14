import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.time.LocalDate;

/**
 * ProgramInterface: all programs implementing this must define run()
 */
interface ProgramInterface {
    void run();
}

/**
 * DailyAffirmationDisplay Program
 *
 * Author: Louiza Beatrice L. Lim
 *
 * Description:
 * This program displays motivational affirmations. The user can choose
 * between a daily affirmation (one per day) or randomly selected ones,
 * and refresh them as many times as desired in random mode.
 */
public class DailyAffirmationDisplay implements ProgramInterface {

    // --- ABSTRACTION ---
    abstract static class AffirmationSource {
        protected String currentAffirmation;
        public abstract String getAffirmation();

        public void displayAffirmation() {
            System.out.println("🌞 Today's Affirmation: " + getAffirmation());
        }
    }

    // --- STATIC AFFIRMATIONS (daily cycle, one per day) ---
    static class StaticAffirmationSource extends AffirmationSource {
        private List<String> affirmations = Arrays.asList(
            "You are capable of amazing things.",
            "Every day is a fresh start.",
            "Believe in yourself and all that you are.",
            "Your potential is limitless.",
            "You are becoming the best version of yourself.",
            "You deserve happiness and success.",
            "Your hard work is paying off.",
            "Good things are coming your way.",
            "You attract positivity and growth.",
            "You are stronger than your challenges."
        );

        @Override
        public String getAffirmation() {
            int dayOfYear = LocalDate.now().getDayOfYear();
            currentAffirmation = affirmations.get(dayOfYear % affirmations.size());
            return currentAffirmation;
        }
    }

    // --- RANDOM AFFIRMATIONS (random selection) ---
    static class RandomAffirmationSource extends AffirmationSource {
        private List<String> affirmations = Arrays.asList(
            "Keep pushing forward!",
            "Progress, not perfection.",
            "You have the power to create change.",
            "Your mind is full of brilliant ideas.",
            "Every small step counts.",
            "You radiate confidence and positivity.",
            "Your future is bright.",
            "You are worthy of every good thing.",
            "Today is full of opportunities.",
            "You are doing your best and that is enough."
        );
        private Random rand = new Random();

        @Override
        public String getAffirmation() {
            currentAffirmation = affirmations.get(rand.nextInt(affirmations.size()));
            return currentAffirmation;
        }
    }

    // --- IMPLEMENT THE INTERFACE ---
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nChoose affirmation mode: (1) Daily affirmation (2) Random)");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline
            AffirmationSource source;

            if (choice == 1) {
                source = new StaticAffirmationSource();
                source.displayAffirmation(); // show daily affirmation
                System.out.print("Press Enter to return to mode selection, or type 'exit' to quit: ");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    keepRunning = false;
                }

            } else if (choice == 2) {
                source = new RandomAffirmationSource();
                char again;
                do {
                    source.displayAffirmation();
                    System.out.print("Refresh for a new one? (y/n): ");
                    again = sc.next().charAt(0);
                    sc.nextLine(); // consume leftover newline
                } while (again == 'y' || again == 'Y');

                System.out.print("Type 'exit' to quit, or press Enter to return to mode selection: ");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    keepRunning = false;
                }

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Have a wonderful day! 🌸");
        sc.close();
    }

    // --- MAIN METHOD ---
    public static void main(String[] args) {
        DailyAffirmationDisplay program = new DailyAffirmationDisplay();
        program.run();
    }
}
