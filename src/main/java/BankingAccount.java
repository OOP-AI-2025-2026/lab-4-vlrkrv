import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class BankingAccount {
    private int balance; // поточний баланс рахунку

    public BankingAccount(Startup s) {
        this.balance = s.getBalance();
    }

    public void debit(Debit d) {
        balance += d.getBalance();
    }

    public void credit(Credit c) {
        balance += c.getBalance();
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingAccount)) return false;
        BankingAccount other = (BankingAccount) o;
        return this.balance == other.balance;
    }

    @Override
    public String toString() {
        return "BankingAccount [balance=" + balance + " грн]";
    }
}
