//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;
import java.util.UUID;

//--------------------------------------------------
//
//	CLASS Order
//
//--------------------------------------------------
/**
 * This class models a order of the shop<br>.
 */
public class Order {
    
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private String orderID;
    private String customerID;
    private ArrayList<Food> buyList;
    private static final int DELIVERY_FEE = 5;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
     /**
     * The constructor creates 1 instance (1 object) of the class Order<br>
     * @param _customerID - The ID of the customer.
     * @param _buyList - The buyList of the customer.
     */
    public Order(String _customerID, ArrayList<Food> _buyList){
        this.orderID = UUID.randomUUID().toString();
        this.customerID = _customerID;
        this.buyList = _buyList;
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------
    /** 
     * Given a concrete order (this), the function returns its buy list.<br>
     * @return The buy list of the customer.
     */
    public ArrayList<Food> getBuyList() {
        return this.buyList;
    }
    
    /** 
     * Given a concrete order (this), the function returns its customer ID.<br>
     * @return The ID of the customer.
     */
    public String getCustomerID() {
        return this.customerID;
    }
    
    /** 
     * Given a concrete order (this), the function returns its customer ID.<br>
     * @return The ID of the order.
     */
    public String getOrderID() {
        return this.orderID;
    }

    //---------------------------------------
    //	SET METHODS
    //---------------------------------------
    /** 
     * Given a concrete order (this), the function updates its buy list.<br>
     * @param buyList
     */
    public void setBuyList(ArrayList<Food> buyList) {
        this.buyList = buyList;
    }
    
    /** 
     * Given a concrete order (this), the function updates its customer ID.<br>
     * @param customerID
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    /** 
     * Given a concrete order (this), the function updates its order ID.<br>
     * @param orderID
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------
    /** 
     * This method adds the food to the buy list.<br>
     * @param _addFood
     */
    public void addFood(Food _addFood){
        this.buyList.add(_addFood);
    }

    /** 
     * This method calculates the total price of an order.<br>
     * @return The total price of an order.
     */
    public int getTotalPrice() {
        int totalAmount = 0;
        for (Food item: this.buyList){
            totalAmount += item.getPrice()*item.getQuantity();
        }
        return totalAmount+DELIVERY_FEE;
    }
}