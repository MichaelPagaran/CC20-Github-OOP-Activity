import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

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
 * between a cycling list of affirmations or randomly selected ones,
 * and refresh them as many times as desired.
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

    // --- STATIC AFFIRMATIONS (cycles through list) ---
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
        private int index = 0;

        @Override
        public String getAffirmation() {
            currentAffirmation = affirmations.get(index);
            index = (index + 1) % affirmations.size();
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

    // --- MAIN METHOD ---
    public static void main(String[] args) {
        DailyAffirmationDisplay program = new DailyAffirmationDisplay();
        program.run();
    }
}
