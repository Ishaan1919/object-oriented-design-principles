import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " is now a customer of " + name);
    }

    public BankAccount openAccount(Customer customer, double initialDeposit) {
        BankAccount newAccount = new BankAccount(this, customer, initialDeposit);
        customer.addAccount(newAccount);
        System.out.println("New account opened for " + customer.getName() + " at " + name);
        return newAccount;
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewBalances() {
        System.out.println("\n" + name + "'s Accounts:");
        for (BankAccount account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: $" + account.getBalance());
        }
    }
}

class BankAccount {
    private Bank bank;
    private Customer customer;
    private double balance;

    public BankAccount(Bank bank, Customer customer, double initialDeposit) {
        this.bank = bank;
        this.customer = customer;
        this.balance = initialDeposit;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAndAccountHolders {
    public static void main(String[] args) {
        Bank bank1 = new Bank("ICICI Bank");
        Bank bank2 = new Bank("HDFC Bank");

        Customer customer1 = new Customer("Ishaan");
        Customer customer2 = new Customer("Hitesh");

        bank1.addCustomer(customer1);
        bank2.addCustomer(customer2);

        bank1.openAccount(customer1, 500);
        bank1.openAccount(customer1, 1000);
        bank2.openAccount(customer2, 1500);

        customer1.viewBalances();
        customer2.viewBalances();

//        Ishaan is now a customer of ICICI Bank
//        Hitesh is now a customer of HDFC Bank
//        New account opened for Ishaan at ICICI Bank
//        New account opened for Ishaan at ICICI Bank
//        New account opened for Hitesh at HDFC Bank
//
//        Ishaan's Accounts:
//        Bank: ICICI Bank, Balance: $500.0
//        Bank: ICICI Bank, Balance: $1000.0
//
//        Hitesh's Accounts:
//        Bank: HDFC Bank, Balance: $1500.0

    }
}
