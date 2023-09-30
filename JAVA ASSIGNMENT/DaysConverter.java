import java.util.InputMismatchException;
import java.util.Scanner;

public class DaysConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the number of days: ");
                int days = scanner.nextInt();

                if (days < 0) {
                    throw new IllegalArgumentException("Number of days cannot be negative.");
                }

                int years = days / 365;
                int remainingDays = days % 365;
                int weeks = remainingDays / 7;
                int remainingDaysInWeeks = remainingDays % 7;

                System.out.println("No. of years: " + years);
                System.out.println("No. of weeks: " + weeks);
                System.out.println("No. of days: " + remainingDaysInWeeks);

                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
