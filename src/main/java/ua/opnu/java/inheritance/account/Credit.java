package ua.opnu.java.inheritance.account;

public class Credit {

    private final int balance; // сума зняття з рахунку

    public Credit(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Credit operation: -" + balance + " грн";
    }
}
