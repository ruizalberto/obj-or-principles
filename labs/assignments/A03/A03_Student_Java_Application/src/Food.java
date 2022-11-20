import java.time.LocalDate;
import java.util.UUID;

public class Food {
    // Fields
    private String foodID,
    name;
    private LocalDate bestBefore;
    private int price;
    
    // Constructors
    public Food(String _name, int _price){
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
    public int getPrice() {
        return this.price;
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

    // EXTRA Methods
    public int getTotalPrice(int _quantity){
        return this.price*_quantity;
    }
}
