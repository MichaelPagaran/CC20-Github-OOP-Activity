import java.util.Arrays;
import java.util.List;

class StaticAffirmationSource extends AffirmationSource {

    private List<String> affirmations = Arrays.asList(
        "You are capable of amazing things.",
        "Every day is a fresh start.",
        "Believe in yourself and all that you are.",
        "Your potential is limitless.",
        "You are becoming the best version of yourself.",
        "You deserve happiness and success.",
        "Your hard work is paying off.",
        "Good things are coming your way.",
        "You attract positivity and growth.",
        "You are stronger than your challenges.",
        "Your dreams are valid.",
        "Keep moving forward — you’re doing great.",
        "You are worthy of love and respect.",
        "You are improving every single day.",
        "You make a difference.",
        "The world is better because you are in it.",
        "You are full of creativity and ideas.",
        "You are brave enough to try.",
        "You are exactly where you need to be.",
        "You choose peace and positivity today."
    );

    private int index = 0;

    @Override
    public String getAffirmation() {
        currentAffirmation = affirmations.get(index);
        index = (index + 1) % affirmations.size(); // cycle through the list
        return currentAffirmation;
    }
}
