package lld.vendingmachine;

public class Product {

    private final String name;
    private final int price;
    private int quantity;

    //Constructor
    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Getter methods
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //Methods
    public boolean isAvailable(){
        return quantity > 0;
    }

    public void dispense(){
        if(quantity > 0){
            quantity--;
        }
    }
}


