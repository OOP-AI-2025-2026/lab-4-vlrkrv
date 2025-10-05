import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double fullTotal;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item i) {
        if (i == null) throw new IllegalArgumentException("Item must not be null");
        bill.add(i);
        fullTotal += i.getPrice();

        if (regularCustomer) {
            double d = i.getDiscount();
            if (d > 0.0) {
                discountCount++;
                discountAmount += d;
            }
        }
    }

    public double getTotal() {
        if (!regularCustomer) {
            return Math.round(bill.getTotal() * 100.0) / 100.0;
        }
        return fullTotal - discountAmount;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || fullTotal <= 0.0) return 0.0;
        double discounted = getTotal();
        return Math.round((100.0 - (discounted * 100.0) / fullTotal) * 1e13) / 1e13;
    }

    public boolean isRegularCustomer() {
        return regularCustomer;
    }

    @Override
    public String toString() {
        return "DiscountBill2{clerk=" + getClerk().getName()
                + ", total=" + getTotal()
                + ", discountCount=" + getDiscountCount()
                + ", discountAmount=" + getDiscountAmount()
                + ", discountPercent=" + getDiscountPercent() + "%}";
    }
}
