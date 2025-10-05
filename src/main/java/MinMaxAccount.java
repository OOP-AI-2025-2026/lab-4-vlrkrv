import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int min; // мінімальний зафіксований баланс
    private int max; // максимальний зафіксований баланс

    public MinMaxAccount(Startup s) {
        super(s);
        int startBalance = s.getBalance();
        this.min = startBalance;
        this.max = startBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    private void updateMinMax() {
        int current = getBalance();
        if (current < min) {
            min = current;
        }
        if (current > max) {
            max = current;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return super.toString() + " [min=" + min + " грн, max=" + max + " грн]";
    }
}
