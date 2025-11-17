package programs.ivan;

import java.util.Scanner;
import core.ProgramInterface;

/**
 * Ivan's Friendly Program
 * This program let's you show Ivan's friends' interest and personal info
 */

// 🧩 TEMPLATE: Copy this to your own folder and modify values.
public class IvanProgram implements ProgramInterface {

    public String getName() { return "What are my friends' Interest"; }
    public String getDescription() { return "States personal information of my friends and their interests"; }
    public String getAuthor() { return "Ivan Larrazabal"; }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! This is your custom program.");

        System.out.println("Choose a friend:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Femboy");
        System.out.print("Enter choice: ");
        int choice = scan.nextInt();
        scan.nextLine();

        Friends friends;

        if (choice == 1) {
            friends = new Male("Pao", 20);
        } else if (choice == 2) {
            friends = new Female("Brinzel", 19);
        } else if (choice == 3) {
            friends = new Femboy("Jose", 20);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Name: " + friends.getName());
        System.out.println("Age: " + friends.getAge());
        System.out.println("Sound: " + friends.makeInterest());
    }
}

abstract class Friends {

    private String name;
    private int age;

    public Friends(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String makeInterest();
}

class Male extends Friends {
    public Male(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeInterest() {
        return "Venny Venny Venny!";
    }
}

class Female extends Friends {
    public Female(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeInterest() {
        return "Tagay Tagay Tagay!";
    }
}

class Femboy extends Friends {
    public Femboy(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeInterest() {
        return "Minecraft Minecraft Minecraft!";
    }
}