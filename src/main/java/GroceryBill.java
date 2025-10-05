import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;
import java.util.ArrayList;
import java.util.List;

public class GroceryBill {

    private final Employee clerk;        // співробітник (касир)
    private final List<Item> items;      // список товарів у чеку

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
    }

    public void add(Item i) {
        if (i != null) {
            items.add(i);
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (Item i : items) {
            total += i.getPrice(); // беремо лише повну ціну
        }
        return total;
    }

    public Employee getClerk() {
        return clerk;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Чек (касир: " + clerk.getName() + ")\n");
        for (Item i : items) {
            sb.append(i.getName())
                    .append(" : ")
                    .append(i.getPrice())
                    .append(" грн\n");
        }
        sb.append("Загальна сума: ").append(getTotal()).append(" грн");
        return sb.toString();
    }
}
