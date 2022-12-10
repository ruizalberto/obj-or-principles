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
     * Given a concrete food (this), the function returns its best before date.<br>
     * @return The best before date of the food.
     */
    public LocalDate getBestBefore() {
        return this.bestBefore;
    }
    
    /**  
     * Given a concrete food (this), the function returns its ID.<br>
     * @return The ID of the food.
     */
    public String getFoodID() {
        return this.foodID;
    }
    
    /** 
     * Given a concrete food (this), the function returns its price.<br>
     * @return The price of the food.
     */
    public double getPrice() {
        return this.price;
    }
    
    /** 
     * Given a concrete food (this), the function returns its quantity.<br>
     * @return The quantity of the food.
     */
    public int getQuantity() {
        return this.quantity;
    }

    //---------------------------------------
    //	SET METHODS
    //---------------------------------------
    /** 
     * Given a concrete food (this), the function updates its name.<br>
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * Given a concrete food (this), the function updates its best before date.<br>
     * @param bestBefore
     */
    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }
    
    /** 
     * Given a concrete food (this), the function updates its ID.<br>
     * @param foodID
     */
    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }
    
    /** 
     * Given a concrete food (this), the function updates its price.<br>
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /** 
     * Given a concrete food (this), the function updates its quantity.<br>
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
