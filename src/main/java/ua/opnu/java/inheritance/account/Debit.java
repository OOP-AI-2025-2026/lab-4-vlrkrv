package ua.opnu.java.inheritance.account;

public class Debit {

    private final int balance; // сума поповнення рахунку

    public Debit(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Debit operation: +" + balance + " грн";
    }
}
