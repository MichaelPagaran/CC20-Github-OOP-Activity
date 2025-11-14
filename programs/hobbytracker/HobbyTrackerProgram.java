package programs.hobbytracker;

import core.ProgramInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Hobby {
    private String name;
    private int frequencyPerWeek;
    private int progress;
    private String goal;


    public Hobby(String name, int frequencyPerWeek, String goal) {
        this.name = name;
        this.frequencyPerWeek = frequencyPerWeek;
        this.progress = 0;
        this.goal = goal;
    }

    public void updateProgress(int additionalProgress) {
        progress += additionalProgress;
        if (progress > 100) progress = 100;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "🎯 " + name + "\n" +
                "   Frequency: " + frequencyPerWeek + " times/week\n" +
                "   Goal: " + goal + "\n" +
                "   Progress: " + progress + "%\n" +
                "---------------------------";
    }
}

/**
 * Hobby Tracker's demonstration
 * A program that allows users to track their hobbies,
 * update their progress, and monitor their weekly frequency goals.
 *
 * Author: Trishya Sofia Marie B. Dadole
 * Description: Demonstrates how a hobby is tracked.
 *
 */
public class HobbyTrackerProgram implements ProgramInterface {

    @Override
    public String getName() {
        return "Hobby Tracker";
    }

    @Override
    public String getDescription() {
        return "Tracks your hobbies, progress, and goals.";
    }

    @Override
    public String getAuthor() {
        return "Trishya Dadole";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Hobby> hobbies = new ArrayList<>();

        // Add sample default hobbies
        hobbies.add(new Hobby("Running", 3, "Run 5km without stopping"));
        hobbies.add(new Hobby("Reading", 5, "Finish 10 books this year"));
        hobbies.add(new Hobby("Coding", 4, "Complete a mini-project each month"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Hobby Tracker Menu ===");
            System.out.println("1. Show all hobbies");
            System.out.println("2. Update progress");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                /**
                 * Option 1: Display all hobbies and their details.
                 */
                case 1:
                    System.out.println("\n--- All Hobbies ---");
                    for (Hobby h : hobbies) {
                        System.out.println(h);
                    }
                    break;

                /**
                 * Option 2: Allow users to update progress and frequency of a hobby.
                 */
                case 2:
                    System.out.print("Enter hobby name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter progress to add (%): ");
                    int progress = scanner.nextInt();

                    System.out.print("Enter new frequency per week: ");
                    int freq = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    boolean found = false;

                    for (Hobby h : hobbies) {
                        if (h.getName().equalsIgnoreCase(name)) {
                            h.updateProgress(progress);
                            h.setFrequencyPerWeek(freq);
                            found = true;
                            System.out.println("Updated successfully!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Hobby not found.");
                    }
                    break;

                /**
                 * Option 3: Exit the program.
                 */
                case 3:
                    exit = true;
                    System.out.println("Exiting Hobby Tracker...");
                    break;

                /**
                 * Handles invalid menu choices.
                 */
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}
