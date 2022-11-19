import java.time.LocalDate;
import java.util.UUID;

public class Food {
    // Fields
    private String foodID;
    private LocalDate bestBefore;
    private int price;
    private int quantity;

    // Constructors
    public Food(int _quantity){
        this.foodID = UUID.randomUUID().toString();
        this.bestBefore = java.time.LocalDate.now().plusDays(7);
        this.price = 30;
        this.quantity = _quantity;
    }

    // GET Methods
    public LocalDate getBestBefore() {
        return this.bestBefore;
    }
    public String getFoodID() {
        return this.foodID;
    }
    public int getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }

    // SET Methods
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
    public int getTotalPrice(){
        return this.price*this.quantity;
    }
}