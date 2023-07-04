import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class BakerySystem {
	
	static double bill=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date purchaseDate = new Date();

        CakeShop cakeShop = new CakeShop();
        CookieShop cookieShop = new CookieShop();

        cakeShop.addItem(new Cake("Chocolate Cake", 15.0, "Chocolate"));
        cakeShop.addItem(new Cake("Strawberry Cake", 12.0, "Strawberry"));
        cookieShop.addItem(new Cookie("Chocolate Chip Cookie", 2.0, "Chocolate Chip"));
        cookieShop.addItem(new Cookie("Oatmeal Raisin Cookie", 1.5, "Oatmeal Raisin"));

        Map<String, Bakery<?>> bakeryMap = new HashMap<>();
        bakeryMap.put("cakes", cakeShop);
        bakeryMap.put("cookies", cookieShop);

        Stack<String> menuStack = new Stack<>();
        menuStack.push("main");

        System.out.println("Welcome to the Bakery System!");

        while (true) {
            String currentMenu = menuStack.peek();

            if (currentMenu.equals("main")) {
                System.out.println("Select an option:");
                System.out.println("1. Cake Shop Menu");
                System.out.println("2. Cookie Shop Menu");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        menuStack.push("cakes");
                        break;
                    case 2:
                        menuStack.push("cookies");
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else if (currentMenu.equals("cakes")) {
                CakeShop currentBakery = (CakeShop) bakeryMap.get("cakes");

                System.out.println("Cake Shop Menu:");
                System.out.println("1. Display Cake Shop Items");
                System.out.println("2. Calculate Discount for Cake Shop");
                System.out.println("3. Calculate Total Price of Cake Shop Items");
                System.out.println("4. Buy Items");
                System.out.println("5. Go Back");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        currentBakery.displayItems();
                        break;
                    case 2:
                        System.out.println("Discount for Cake Shop: " + currentBakery.calculateDiscount());
                        break;
                    case 3:
                        System.out.println("Total Price of Cake Shop Items: $" + currentBakery.getTotalPrice());
                        break;
                    case 4:
                    	double price;
                    	price= buyItems(currentBakery, scanner, purchaseDate,bill);
                    	bill+=price;
                        break;
                    case 5:
                        menuStack.pop();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else if (currentMenu.equals("cookies")) {
                CookieShop currentBakery = (CookieShop) bakeryMap.get("cookies");

                System.out.println("Cookie Shop Menu:");
                System.out.println("1. Display Cookie Shop Items");
                System.out.println("2. Calculate Discount for Cookie Shop");
                System.out.println("3. Calculate Total Price of Cookie Shop Items (Recursive)");
                System.out.println("4. Buy Items");
                System.out.println("5. Go Back");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        currentBakery.displayItems();
                        break;
                    case 2:
                        System.out.println("Discount for Cookie Shop: " + currentBakery.calculateDiscount());
                        break;
                    case 3:
                        System.out.println("Total Price of Cookie Shop Items (Recursive): $" + currentBakery.getTotalPriceRecursive());
                        break;
                    case 4:
                    	double price;
                    	price= buyItems(currentBakery, scanner, purchaseDate,bill);
                    	bill+=price;
                        break;
                    case 5:
                        menuStack.pop();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static double buyItems(Bakery<?> bakery, Scanner scanner, Date purchaseDate,double bill) {
        
    	
    	bakery.displayItems();
    	
    	System.out.println("Enter the index of the item you want to buy:");
        int index = scanner.nextInt();

        try {
            BakeryItem item = bakery.items.get(index);

            System.out.println("Item: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println("Purchase Date: " + purchaseDate);

            double discount = bakery.calculateDiscount();
            double discountedPrice =(item.getPrice() * discount);
            double PurchasePrice = (item.getPrice() - (item.getPrice() * discount));

            System.out.println("Discounted Price: $" + discountedPrice);
           
            
            System.out.println("Purchase for selected item: " + PurchasePrice);
            
            bill+=PurchasePrice;
            System.out.println("Total Bill: "+ bill);
            
            System.out.println("Enjoy your purchase!\n\n");
            
            bakery.items.remove(index);
        } catch (IndexOutOfBoundsException e) {
        	
            System.out.println("Invalid item index. Please try again.");
        }
        
        return bill;
    
    }
}