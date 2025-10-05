package ua.opnu.java.inheritance.bill;

public class Item {

    private final String name;
    private final double price;
    private final double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (ціна: " + price + " грн, знижка: " + discount + " грн)";
    }
}
