package programs.minsoo;
import java.util.Scanner;
import core.ProgramInterface;

/**
 * Mood to Color Program
 * This program asks the user how they feel today, and based on their
 * mood selection, it prints a suggested color and a short phrase that represents their emotion.
 *
 * Author: Min Soo
 * Description: Describes user mood to a color as well as an attached phrase based on the color.
 */

public class moodtocolor implements ProgramInterface {
    public String getName() {
        return "Mood to Color";
    }
    
    public String getDescription() {
        return "Converts your mood to a color with inspirational messages";
    }
    
    public String getAuthor() {
        return "minsoo";
    }
        public void run() { 

        Scanner scanner = new Scanner(System.in);

        System.out.println("How are you feeling today?: ");
        String mood = scanner.nextLine().toLowerCase();

        String color;

        if(mood.contains("happy") || mood.contains("excited")){
            color = " Your color is yellow! You are full of joy and excitement! Have and amazing day!";
        }
        else if (mood.contains("sad") || mood.contains("down")){
            color = " Your color is blue! Don't let the saddness of today change who you are, you have amazing power in you, use it wisely!";
        }
        else if (mood.contains("angry") || mood.contains("irritated")){
            color = " Your color is purple! The anger that you feel today is nothing compared to what the joy you are about to get, you are in control of your emotions!";
        }
        else if (mood.contains("loved") || mood.contains("deeply in love")){
            color = " Your color is red! Love is patient, love is kind. It does not boast, it does not envy, it is not proud!";
        }
        else if (mood.contains("depressed") || mood.contains("miserable")){
            color = " Your color is black! I hope and pray thatt whatever pain you are going through, it will heal. You are loved!";
        } else { 
            color = " Your color is White! Couldn't quite get your mood, but remember that every color has its beauty! You just have to find it!";
        }

        System.out.println("Your mood to color is: " + color);
        scanner.close();
        }

    }

