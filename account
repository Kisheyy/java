public class Account {
    private double balance;


    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0; 
        }
    }

  
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited $" + amount + ". Current balance: $" + this.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                System.out.println("Withdrew $" + amount + ". Current balance: $" + this.balance);
            } else {
                System.out.println("Insufficient funds. A $5 penalty will be charged.");
                this.balance -= 5;
                System.out.println("Penalty charged: $5. Current balance: $" + this.balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }


    public void inquireBalance() {
        System.out.println("Current balance: $" + this.balance);
    }


    public void computeInterest(double rate) {
        if (rate > 0) {
            double interest = (rate / 100) * this.balance;
            this.balance += interest;
            System.out.println("Interest of $" + interest + " added. Current balance: $" + this.balance);
        } else {
            System.out.println("Invalid interest rate.");
        }
    }

    public static void main(String[] args) {
        Account account = new Account(1000); 
        account.deposit(500);
        account.withdraw(1000);
        account.computeInterest(2);
        account.inquireBalance();
    }
}
