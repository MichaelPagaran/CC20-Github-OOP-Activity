import java.util.*;

// --- ABSTRACTION ---
abstract class AffirmationSource {
    protected String currentAffirmation;

    public abstract String getAffirmation(); // abstract method

    public void displayAffirmation() {
        System.out.println("🌞 Today's Affirmation: " + getAffirmation());
    }
}
