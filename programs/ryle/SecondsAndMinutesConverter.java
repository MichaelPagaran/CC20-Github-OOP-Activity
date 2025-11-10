import java.util.Scanner;

public class SecondsAndMinutesConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total seconds: ");
        int totalSeconds = scanner.nextInt();

        try {
            TimeDuration duration = new TimeDuration(totalSeconds);
            System.out.println("Converted time: " + duration.getDurationString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

class TimeDuration {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeDuration(int totalSeconds) {
        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Invalid input: seconds cannot be negative!");
        }
        this.hours = totalSeconds / 3600;
        this.minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;
    }

    public String getDurationString() {
        return hours + "h " + minutes + "m " + seconds + "s";
    }
}
