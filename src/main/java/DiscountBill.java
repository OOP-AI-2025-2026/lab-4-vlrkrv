import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double fullTotal;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        if (i == null) {
            throw new IllegalArgumentException("Item must not be null");
        }
        super.add(i);
        fullTotal += i.getPrice();
        if (regularCustomer) {
            double d = i.getDiscount();
            if (d > 0.0) {
                discountCount++;
                discountAmount += d;
            }
        }
    }

    @Override
    public double getTotal() {
        if (!regularCustomer) {
            return Math.round(super.getTotal() * 100.0) / 100.0;
        }
        return fullTotal - discountAmount;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || fullTotal <= 0.0) {
            return 0.0;
        }
        double discounted = getTotal();
        return Math.round((100.0 - (discounted * 100.0) / fullTotal) * 1e13) / 1e13;
        //return 100.0 - (discounted * 100.0) / fullTotal;
    }

    public boolean isRegularCustomer() {
        return regularCustomer;
    }
}
