package programs.PaoRPS;

import java.util.*;
import core.ProgramInterface;

public class RPS implements ProgramInterface {

    @Override
    public String getName() {
        return "Rock-Paper-Scissors";
    }

    @Override
    public String getDescription() {
        return "A console-based Rock-Paper-Scissors game against the computer.";
    }

    @Override
    public String getAuthor() {
        return "Pao Ysug";
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"rock", "paper", "scissors"};

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("=== Rock-Paper-Scissors ===");
        System.out.println("First to 5 points wins!");
        System.out.println("---------------------------");

        while (playerScore < 5 && computerScore < 5) {
            System.out.print("\nEnter your move (rock, paper, scissors): ");
            String playerMove = sc.nextLine().toLowerCase();

            if (!Arrays.asList(moves).contains(playerMove)) {
                System.out.println("Invalid move! Please choose rock, paper, or scissors.");
                continue;
            }

            String computerMove = moves[random.nextInt(3)];
            System.out.println("Computer chose: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (
                (playerMove.equals("rock") && computerMove.equals("scissors")) ||
                (playerMove.equals("paper") && computerMove.equals("rock")) ||
                (playerMove.equals("scissors") && computerMove.equals("paper"))
            ) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }

            System.out.println("Score: You " + playerScore + " - " + computerScore + " Computer");
        }

        System.out.println("\n=== Game Over ===");
        if (playerScore > computerScore) {
            System.out.println("🎉 Congratulations, you win the match!");
        } else {
            System.out.println("💻 The computer wins the match. Better luck next time!");
        }

        System.out.println("---------------------------");
    }
}

