package programs.wordcounter;

import core.ProgramInterface;
import java.util.Scanner;

/**
 * Simple Word Counter demonstration.
 * This program prompts the user for text, then counts and displays the number of words.
 *
 * Author: Peterson C. Pepito
 * Description: Counts the number of words in a given text input.
 */
public class WordCounter implements ProgramInterface {

    @Override
    public String getName() {
        return "Simple Word Counter";
    }

    @Override
    public String getDescription() {
        return "Counts the number of words in a given text input.";
    }

    @Override
    public String getAuthor() {
        return "Peterson Pepito";
    }

    /**
     * Runs the word counting logic.
     * 
     */
    @Override
    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\n--- " + getName() + " ---");
            System.out.println(getDescription());
            
            System.out.print("\nPlease enter your text: ");
            String text = sc.nextLine();
            
            int wordCount = 0;
            
            if (text != null && !text.trim().isEmpty()) {
                String[] words = text.trim().split("\\s+");
                wordCount = words.length;
            }
            
            System.out.println("\n--- Word Count Result ---");
            System.out.println("Total words counted: " + wordCount);
        }
    }
}
