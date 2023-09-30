public class Customer {
    private int accountNo;
    private String accName;
    private double balance;

    public Customer(int accountNo, String accName, double balance) {
        this.accountNo = accountNo;
        this.accName = accName;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        System.out.println(accName + " is depositing $" + amount);
        balance += amount;
        System.out.println("New balance after deposit: $" + balance);
        notify();
    }

    public synchronized void withdraw(double amount) {
        System.out.println(accName + " is trying to withdraw $" + amount);

        while (balance < amount) {
            try {
                System.out.println("Insufficient balance. Waiting for deposit...");
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println(accName + " has successfully withdrawn $" + amount);
        System.out.println("New balance after withdrawal: $" + balance);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Customer customer = new Customer(101, "John Doe", 1000);

        Thread depositThread = new Thread(() -> {
            customer.deposit(500);
        });

        Thread withdrawThread = new Thread(() -> {
            customer.withdraw(1500);
        });

        depositThread.start();
        withdrawThread.start();
    }
}
