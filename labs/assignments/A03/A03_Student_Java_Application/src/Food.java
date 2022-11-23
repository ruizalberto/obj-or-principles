import java.time.LocalDate;
import java.util.UUID;

public class Food {
    // Fields
    private String foodID,
    name;
    private LocalDate bestBefore;
    private double price;
    private int quantity;
    
    // Constructors
    public Food(String _name, double _price){
        this.name = _name;
        this.foodID = UUID.randomUUID().toString();
        this.bestBefore = java.time.LocalDate.now().plusDays(7);
        this.price = _price;
    }

    // GET Methods
    public String getName() {
        return this.name;
    }
    public LocalDate getBestBefore() {
        return this.bestBefore;
    }
    public String getFoodID() {
        return this.foodID;
    }
    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }

    // SET Methods
    public void setName(String name) {
        this.name = name;
    }
    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }
    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // EXTRA Methods
}
