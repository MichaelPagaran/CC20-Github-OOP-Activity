package programs.aaron;

import java.util.Scanner;
import core.Program;

//ABSTRACTION
abstract class Game {
    protected String playerName;

    public Game(String playerName) {
        this.playerName = playerName;
    }

    public abstract void play();
}

//ENCAPSULATION
class Player {
    private String name;
    private int chosenNumber;

    public Player(String name) {
        this.name = name;
    }

    public void setChosenNumber(int number) {
        this.chosenNumber = number;
    }

    public int getChosenNumber() {
        return chosenNumber;
    }

    public String getName() {
        return name;
    }
}

//ENCAPSULATION
class LoadingScreen {
    public void fakeLoading(String message, int dots) {
        System.out.print(message);
        for (int i = 0; i < dots; i++) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();
    }
}

//POLYMORPHISM
class GuessEngine {
    public int guess(Player player) {
        return player.getChosenNumber();
    }
}

//INHERITANCE + POLYMORPHISM
class MindReaderGame extends Game {
    private Player player;
    private LoadingScreen loadingScreen;
    private GuessEngine guessEngine;

    public MindReaderGame(Player player) {
        super(player.getName());
        this.player = player;
        this.loadingScreen = new LoadingScreen();
        this.guessEngine = new GuessEngine();
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, " + playerName + "!");
        System.out.print("Think of a number between 1 and 10: ");

        int number = -1;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number < 1 || number > 10) {
                    System.out.print("Enter a number between 1 and 10: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("That's not a number! Try again: ");
            }
        }

        player.setChosenNumber(number);

        System.out.println("\nreading your mind...");
        loadingScreen.fakeLoading("Scanning your brainwaves", 3);
        loadingScreen.fakeLoading("Accessing NASAs supercomputer", 4);
        loadingScreen.fakeLoading("Consulting psychic hotline", 3);
        loadingScreen.fakeLoading("Asking God", 4);

        int guessed = guessEngine.guess(player);
        System.out.println("\nYour number is... " + guessed + "!");
    }
}

public class NumberGuesser extends Program {

    @Override
    public String getName() {
        return "Mind Reader Number Guesser";
    }

    @Override
    public String getDescription() {
        return "A OOP-based number guessing program that reads your mind.";
    }

    @Override
    public String getAuthor() {
        return "Aaron";
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player(name);
        Game game = new MindReaderGame(player);
        game.play();
    }
}
