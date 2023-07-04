// Cake class inherits from BakeryItem and represents a cake
class Cake extends BakeryItem {
    private String flavor;

    public Cake(String name, double price, String flavor) {
        super(name, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }
}