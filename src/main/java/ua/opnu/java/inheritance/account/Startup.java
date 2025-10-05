package ua.opnu.java.inheritance.account;

public class Startup {
    private final int balance; // стартовий баланс рахунку

    public Startup(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Startup balance: " + balance + " грн";
    }
}
