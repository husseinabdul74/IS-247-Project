// CookieShop class inherits from Bakery and represents a cookie shop
class CookieShop extends Bakery<Cookie> {
    @Override
    public double calculateDiscount() {
        return 0.05; // 5% discount for cookie shop
    }

    @Override
    public void specialOffer() {
        System.out.println("Special Offer: Buy two cookies and get 50% off on the third one!");
    }
}
