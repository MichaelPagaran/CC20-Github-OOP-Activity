package programs.fibonacci;

import java.util.Scanner;
import ProgramInterface;

// Simple example: prints Fibonacci sequence up to n terms.
public class FibonacciProgram implements ProgramInterface {

    public String getName() { return "Fibonacci Sequence"; }
    public String getDescription() { return "Displays Fibonacci sequence up to n terms."; }
    public String getAuthor() { return "Example Author"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        int a = 0, b = 1;

        System.out.print("Fibonacci: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
