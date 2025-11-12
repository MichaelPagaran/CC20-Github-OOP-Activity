package programs.sia;

import java.util.*;
import programs.ProgramInterface;

public class Formula1ne implements ProgramInterface {

    @Override
    public String getAuthor() {
        return "Your Name";
    }

    @Override
    public void run() {
        String[] drivers = {
            "Max Verstappen", "Lewis Hamilton", "Charles Leclerc",
            "Lando Norris", "George Russell"
        };

        int laps = 5;
        Map<String, Double> totalTimes = new HashMap<>();

        System.out.println("🏁 Formula 1 Mini Race Simulation 🏁\n");

        for (String driver : drivers) {
            totalTimes.put(driver, 0.0);
        }

        Random random = new Random();

        for (int lap = 1; lap <= laps; lap++) {
            System.out.println("--- Lap " + lap + " ---");
            for (String driver : drivers) {
                double lapTime = 1.15 + (1.25 - 1.15) * random.nextDouble();
                totalTimes.put(driver, totalTimes.get(driver) + lapTime);
                System.out.printf("%s completed the lap in %.3f min%n", driver, lapTime);
            }
            System.out.println();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<Map.Entry<String, Double>> results = new ArrayList<>(totalTimes.entrySet());
        results.sort(Map.Entry.comparingByValue());

        System.out.println("🏆 Final Results 🏆");
        int position = 1;
        for (Map.Entry<String, Double> entry : results) {
            System.out.printf("%d. %s - Total time: %.3f min%n",
                              position++, entry.getKey(), entry.getValue());
        }
    }
}
