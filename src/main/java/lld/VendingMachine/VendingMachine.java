package lld.VendingMachine;

import java.util.HashMap;
import java.util.Map;

// ==================== MAIN CLASS ====================
public class VendingMachine {
    //inventoryMap : name -> Product
    private final Map<String, Product> inventoryMap = new HashMap<>();
    private int currentBalance = 0;
    private Product selectedProduct = null;

    //Constructor
    public VendingMachine() {
        //Initialize products for demo
        inventoryMap.put("Coke", new Product("Coke", 25, 10));
        inventoryMap.put("Water", new Product("Water", 15, 8));
        inventoryMap.put("Chips", new Product("Chips", 20, 15));
    }

    //APIs
    public void insertCoin(Coin coin) {
        currentBalance += coin.getValue();
        System.out.println("Inserted ₹" + coin.getValue() + " | Current Balance: ₹" + currentBalance);
    }

    public void selectProduct(String productName) {
        Product product = inventoryMap.get(productName);
        if (product == null) {
            System.out.println("Product not found");
            return;
        }
        if (!product.isAvailable()) {
            System.out.println(productName + " is out of stock");
            return;
        }
        if (currentBalance < product.getPrice()) {
            System.out.println("Insufficient balance. Need ₹" + (product.getPrice() - currentBalance) + " more");
            return;
        }

        selectedProduct = product;
        System.out.println("Selected: " + productName + " | Price: ₹" + product.getPrice());
    }

    public void dispense() {
        if (selectedProduct == null) {
            System.out.println("No product selected");
            return;
        }

        selectedProduct.dispense();
        int change = currentBalance - selectedProduct.getPrice();

        System.out.println("✅ Dispensed: " + selectedProduct.getName());
        if (change > 0) {
            System.out.println("Returning change: ₹" + change);
        }

        // Reset transaction
        currentBalance = 0;
        selectedProduct = null;
    }

    public void showInventory() {
        System.out.println("\n=== Current Inventory ===");
        for (Product p : inventoryMap.values()) {
            System.out.println(p.getName() + " - ₹" + p.getPrice() + " | Stock: " + p.getQuantity());
        }
    }

    public void cancelTransaction() {
        if (currentBalance > 0) {
            System.out.println("Transaction cancelled. Returning ₹" + currentBalance);
        }
        currentBalance = 0;
        selectedProduct = null;
    }

}
