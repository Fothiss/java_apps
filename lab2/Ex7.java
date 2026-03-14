package lab2;

interface BankAccountInterface {
    void createAccount(String accountNumber, String ownerName, double initialBalance);
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getAccountInfo();
}

class BankAccount implements BankAccountInterface {
    private String accountNumber;
    private String ownerName;
    private double balance;
    
    @Override
    public void createAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Депозит: +" + amount + ". Новый баланс: " + balance);
        }
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снятие: -" + amount + ". Новый баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String getAccountInfo() {
        return "Счет: " + accountNumber + ", Владелец: " + ownerName + ", Баланс: " + balance;
    }
}

public class Ex7 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.createAccount("123456", "Иван Петров", 1000);
        
        System.out.println(account.getAccountInfo());
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000);
        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
