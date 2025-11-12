package programs.Segovia;

import core.ProgramInterface;
import java.util.*;

public class petTracker implements ProgramInterface {

    public String getName() { return "House Pet Tracker"; }
    public String getDescription() { return "This program will allow you to keep track of your current pets, and also allow you to add, remove, and check removed pets."; }
    public String getAuthor() { return "Prince Jan A. Segovia"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        PetManager petManager = new PetManager();

        while (true) {
            System.out.println("\n--- House Pet Tracker ---");
            System.out.println("1. Add a pet");
            System.out.println("2. Remove a pet");
            System.out.println("3. View current pets");
            System.out.println("4. View removed pets");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter pet name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter pet type (dog/cat): ");
                    String type = sc.nextLine().toLowerCase();

                    Pet pet;
                    if (type.equals("dog")) pet = new Dog(name);
                    else if (type.equals("cat")) pet = new Cat(name);
                    else {
                        System.out.println("Unknown pet type, defaulting to generic pet.");
                        pet = new Pet(name);
                    }

                    petManager.addPet(pet);
                    System.out.println("Pet added successfully!");
                    break;

                case 2:
                    System.out.print("Enter pet name to remove: ");
                    String removeName = sc.nextLine();
                    petManager.removePet(removeName);
                    break;

                case 3:
                    petManager.displayCurrentPets();
                    break;

                case 4:
                    petManager.displayRemovedPets();
                    break;

                case 5:
                    System.out.println("Exiting Pet Tracker. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Optional main method to run directly
    public static void main(String[] args) {
        petTracker program = new petTracker();
        program.run();
    }
}

/* ------------------------------
   PET CLASSES
   Demonstrate Encapsulation,
   Inheritance & Polymorphism
   ------------------------------ */

class Pet {
    private String name;

    public Pet(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String speak() {
        return "This pet makes a sound.";
    }

    @Override
    public String toString() {
        return "Pet: " + name;
    }
}

class Dog extends Pet {
    public Dog(String name) { super(name); }

    @Override
    public String speak() {
        return getName() + " says: Woof!";
    }
}

class Cat extends Pet {
    public Cat(String name) { super(name); }

    @Override
    public String speak() {
        return getName() + " says: Meow!";
    }
}

/* ------------------------------
   PET MANAGER CLASS
   Demonstrates Abstraction
   ------------------------------ */

class PetManager {
    private List<Pet> currentPets = new ArrayList<>();
    private List<Pet> removedPets = new ArrayList<>();

    public void addPet(Pet pet) {
        currentPets.add(pet);
    }

    public void removePet(String name) {
        Pet found = null;
        for (Pet p : currentPets) {
            if (p.getName().equalsIgnoreCase(name)) {
                found = p;
                break;
            }
        }

        if (found != null) {
            currentPets.remove(found);
            removedPets.add(found);
            System.out.println(name + " has been removed.");
        } else {
            System.out.println("No pet found with that name.");
        }
    }

    public void displayCurrentPets() {
        if (currentPets.isEmpty()) {
            System.out.println("No current pets.");
            return;
        }
        System.out.println("Current Pets:");
        for (Pet p : currentPets) {
            System.out.println("- " + p.getName() + " | " + p.speak());
        }
    }

    public void displayRemovedPets() {
        if (removedPets.isEmpty()) {
            System.out.println("No removed pets yet.");
            return;
        }
        System.out.println("Removed Pets:");
        for (Pet p : removedPets) {
            System.out.println("- " + p.getName());
        }
    }
}

