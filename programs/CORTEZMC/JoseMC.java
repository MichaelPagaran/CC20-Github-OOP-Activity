package programs.CORTEZMC;

import core.ProgramInterface;
import java.util.Random;
import java.util.Scanner;



abstract class MobNameGenerator {
    protected String[] adjectives;
    protected String[] mobs;
    protected String[] titles;
    protected Random rand = new Random();

    public MobNameGenerator() {
        adjectives = new String[]{"Shadow", "Ancient", "Frost", "Storm", "Elder",
                                  "Crimson", "Thunder", "Phantom", "Obsidian", "Cursed",
                                  "Savage", "Emerald", "Netherborn", "Iceborn","SandBorn"};
        mobs = new String[]{"Creeper", "Enderman", "Skeleton", "Spider", "Guardian",
                            "Piglin", "Blaze", "Ghast", "Warden", "Drowned", "Shulker"};
        titles = new String[]{"of the Abyss", "the Unseen", "the Eternal", "of the Night",
                              "the Reckoning", "the Forgotten", "of the Nether", "the Wanderer",
                              "the Whisperer", "of Doom", "the Devourer"};
    }

    
    public abstract String generateName();
}


class CoolMobNameGenerator extends MobNameGenerator {

    
    @Override
    public String generateName() {
        String name = adjectives[rand.nextInt(adjectives.length)] + " " +
                      mobs[rand.nextInt(mobs.length)] + " " +
                      titles[rand.nextInt(titles.length)];
        return name;
    }
}
/** This program generates unique and cool names for Minecraft mobs.
 * The mob name is created by combining random adjectives, mob types, and titles.
 * You can generate new names by pressing Enter, and exit the program by typing 'stop'.
 * 
 * Author: Jose Cortez
 * Description: Minecraft Mob Name Generator
 * 
 */

public class JoseMC implements ProgramInterface {

    private static boolean running = true; 

    
    public String getName() { return "Minecraft Mob Name Generator"; }
    public String getDescription() { return "Generates a unique and cool name for a Minecraft mob."; }
    public String getAuthor() { return "Jose Cortez"; }

    
    public void run() {
        Scanner sc = new Scanner(System.in);
        CoolMobNameGenerator generator = new CoolMobNameGenerator();

        System.out.println("Welcome to the Minecraft Mob Name Generator!");
        System.out.println("Press Enter to generate a cool mob name or type 'stop' to exit.");

        while (running) {
            System.out.print("\nYour choice: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                running = false;
                System.out.println("Exiting the generator. Goodbye!");
            } else {
                String mobName = generator.generateName();
                System.out.println(">>> " + mobName + " <<<");
            }
        }

        sc.close();
    }

    
    public static void main(String[] args) {
        new JoseMC().run();
    }
}
