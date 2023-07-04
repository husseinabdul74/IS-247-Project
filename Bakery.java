import java.util.ArrayList;
import java.util.List;

// Abstract class Bakery provides common functionality for bakery types
abstract class Bakery<T extends BakeryItem> implements Discountable {
    protected List<T> items;
    protected static int bakeryCount = 0;

    public Bakery() {
        items = new ArrayList<>();
        bakeryCount++;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println("Name: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println();
        }
    }

    public static int getBakeryCount() {
        return bakeryCount;
    }

    public abstract void specialOffer();

    public double getTotalPrice() {
        double total = 0;
        for (T item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double getTotalPriceRecursive() {
        return calculateTotalPriceRecursive(items.size() - 1);
    }

    private double calculateTotalPriceRecursive(int index) {
        if (index < 0) {
            return 0;
        } else {
            T item = items.get(index);
            return item.getPrice() + calculateTotalPriceRecursive(index - 1);
        }
    }
}
