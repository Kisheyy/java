public import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SavingsBankApplication {
    private static final String DB_URL = "jdbc:mysql://localhost/bank"; 
    private static final String DB_USER = "your_username"; 
    private static final String DB_PASSWORD = "your_password"; 

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("Savings Bank Application");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                
                if (choice == 1 || choice == 2) {
                    System.out.print("Enter Account Number: ");
                    int accn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name of Accountant: ");
                    String accountantName = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    String operation = (choice == 1) ? "D" : "W"; 
                    
            
                    String insertQuery = "INSERT INTO transactions (Accn, NameOfAccountant, TypeOfOperation, Amount) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setInt(1, accn);
                    preparedStatement.setString(2, accountantName);
                    preparedStatement.setString(3, operation);
                    preparedStatement.setDouble(4, amount);
                    preparedStatement.executeUpdate();
                    
                    System.out.println("Transaction completed.");
                } else if (choice == 3) {
                    System.out.println("Exiting the application.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
 Main {
    
}
