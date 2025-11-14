import java.util.Arrays;
import java.util.List;
import java.util.Random;

class RandomAffirmationSource extends AffirmationSource {

    private List<String> affirmations = Arrays.asList(
        "Keep pushing forward!",
        "Progress, not perfection.",
        "You have the power to create change.",
        "Your mind is full of brilliant ideas.",
        "Every small step counts.",
        "You radiate confidence and positivity.",
        "Your future is bright.",
        "You are worthy of every good thing.",
        "Today is full of opportunities.",
        "You are doing your best and that is enough.",
        "Your kindness makes the world better.",
        "You can handle anything that comes your way.",
        "You are becoming more confident every day.",
        "You are calm, focused, and ready.",
        "Success flows to you naturally.",
        "You are in control of your life.",
        "You deserve rest, joy, and peace.",
        "You are growing in powerful ways.",
        "You inspire others without even knowing it.",
        "You are guided, supported, and strong."
    );

    @Override
    public String getAffirmation() {
        Random rand = new Random();
        currentAffirmation = affirmations.get(rand.nextInt(affirmations.size()));
        return currentAffirmation;
    }
}
