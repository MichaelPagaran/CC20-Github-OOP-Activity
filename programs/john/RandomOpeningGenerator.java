package programs.john;

import java.util.Scanner;
import core.ProgramInterface;

// 🧩 TEMPLATE: Copy this to your own folder and modify values.
public class RandomOpeningGenerator implements ProgramInterface {

    public String getName() { return "Random opening generator"; }
    public String getDescription() { return "Randomly selects a starting move for black or white pieces in a game of Chess."; }
    public String getAuthor() { return "John Ryan Uy"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! This is your custom program.");
        // Add your logic here
    }
}
