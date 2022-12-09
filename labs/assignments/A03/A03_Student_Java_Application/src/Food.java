//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.time.LocalDate;
import java.util.UUID;

//--------------------------------------------------
//
//	CLASS Food
//
//--------------------------------------------------
/**
 * This class models food for the shop menu<br>.
 */
public class Food {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private String foodID,
    name;
    private LocalDate bestBefore;
    private double price;
    private int quantity;
    
    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Food<br>
     * @param _name - The name of the food.
     * @param _price - The price of the food.
     */
    public Food(String _name, double _price){
        this.name = _name;
        this.foodID = UUID.randomUUID().toString();
        this.bestBefore = java.time.LocalDate.now().plusDays(7);
        this.price = _price;
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------
    /** 
     * Given a concrete food (this), the function returns its name.<br>
     * @return The name of the food.
     */
    public String getName() {
        return this.name;
    }
    
    /** 
     * @return LocalDate
     */
    public LocalDate getBestBefore() {
        return this.bestBefore;
    }
    
    /** 
     * @return String
     */
    public String getFoodID() {
        return this.foodID;
    }
    
    /** 
     * @return double
     */
    public double getPrice() {
        return this.price;
    }
    
    /** 
     * @return int
     */
    public int getQuantity() {
        return this.quantity;
    }


    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * @param bestBefore
     */
    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }
    
    /** 
     * @param foodID
     */
    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }
    
    /** 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /** 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
