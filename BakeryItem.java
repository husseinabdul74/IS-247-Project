// BakeryItem class represents a generic bakery item
class BakeryItem {
    protected String name;
    protected double price;

    public BakeryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}