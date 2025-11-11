package programs.balacuit;

import java.util.*;
import core.ProgramInterface;

public class BalacuitStudyTracker implements ProgramInterface {
    @Override public String getName() { return "Balacuit Study Tracker"; }
    @Override public String getDescription() { return "Tracks how long a student studies and gives feedback."; }
    @Override public String getAuthor() { return "Zacki B. Balacuit"; }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter subject you studied: ");
        String subject = sc.nextLine();
        System.out.print("How many hours did you study today? ");
        double hours = sc.nextDouble();

        System.out.println("\n--- Study Summary ---");
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Hours studied: " + hours);

        if (hours < 2) System.out.println("You can do better tomorrow!");
        else if (hours <= 4) System.out.println("Nice! You’re keeping a good pace.");
        else System.out.println("Excellent! You’re on fire!");
    }
}

