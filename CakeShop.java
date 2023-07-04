
// CakeShop class inherits from Bakery and represents a cake shop
class CakeShop extends Bakery<Cake> {
    @Override
    public double calculateDiscount() {
        return 0.1; // 10% discount for cake shop
    }

    @Override
    public void specialOffer() {
        System.out.println("Special Offer: Buy one cake and get one cookie free!");
    }
}