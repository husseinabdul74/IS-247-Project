// Cookie class inherits from BakeryItem and represents a cookie
class Cookie extends BakeryItem {
    private String type;

    public Cookie(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}