package programs.john;

import java.util.Scanner;
import core.ProgramInterface;
import java.util.Random;

/**
* A program that randomly selects which 
* starting move to play for black or white pieces.
* 
* Author: John Ryan Uy 
* Description: Randomly selects a legal starting move for black or white pieces in a game of Chess.
*/ 
public class RandomOpeningGenerator implements ProgramInterface {

    public String getName() { return "Random opening generator"; }
    public String getDescription() { return "Randomly selects a starting move for black or white pieces in a game of Chess."; }
    public String getAuthor() { return "John Ryan Uy"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Random Opening Generator!");
        System.out.println("Select your side:");
        System.out.println("1 = White");
        System.out.println("2 = Black");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        
        // All 20 legal starting moves for White
        String[] whiteMoves = {
            "a3", "a4", "b3", "b4", "c3", "c4", "d3", "d4",
            "e3", "e4", "f3", "f4", "g3", "g4", "h3", "h4",
            "Na3", "Nc3", "Nf3", "Nh3"
        };
        
        // All 20 legal starting moves for Black
        String[] blackMoves = {
            "a6", "a5", "b6", "b5", "c6", "c5", "d6", "d5",
            "e6", "e5", "f6", "f5", "g6", "g5", "h6", "h5",
            "Na6", "Nc6", "Nf6", "Nh6"
        };
        
    }
}
