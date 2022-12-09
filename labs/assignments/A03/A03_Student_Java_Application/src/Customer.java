//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;
import java.util.UUID;

//--------------------------------------------------
//
//	CLASS Customer
//
//--------------------------------------------------
/**
 * This class models a customer of the shop<br>.
 */
public class Customer {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private String name,
    homeAddress,
    customerID;
    private Order currentOrder;
    private ArrayList<Order> pastOrders;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Customer<br>
     * @param _name - The name of the customer.
     * @param _homeAddress - The home address of the customer.
     */
    public Customer(String _name, String _homeAddress){
        this.name = _name;
        this.homeAddress = _homeAddress;
        this.customerID = UUID.randomUUID().toString();
        this.currentOrder = null;
        this.pastOrders = new ArrayList<Order>();
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------
    /** 
     * Given a concrete customer (this), the function returns its current order.<br>
     * @return The current order of a customer.
     */
    public Order getCurrentOrder() {
        return this.currentOrder;
    }
    
    /** 
     * Given a concrete customer (this), the function returns its home address.<br>
     * @return The home address of a customer.
     */
    public String getHomeAddress() {
        return this.homeAddress;
    }
    
    /** 
     * Given a concrete customer (this), the function returns its ID.<br>
     * @return The ID of a customer.
     */
    public String getCustomerID() {
        return this.customerID;
    }
    
    /** 
     * Given a concrete customer (this), the function returns its name.<br>
     * @return The name of a customer.
     */
    public String getName() {
        return this.name;
    }
    
    /** 
     * Given a concrete customer (this), the function returns its past orders.<br>
     * @return The past orders of a customer.
     */
    public ArrayList<Order> getPastOrders() {
        return this.pastOrders;
    }

    //---------------------------------------
    //	SET METHODS
    //---------------------------------------
    /** 
     * Given a concrete customer (this), the function updates its current order object.<br>
     * @param currentOrder
     */
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    
    /** 
     * Given a concrete customer (this), the function updates its home address.<br>
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    /** 
     * Given a concrete customer (this), the function updates its name.<br>
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * Given a concrete customer (this), the function updates its past orders.<br>
     * @param pastOrders
     */
    public void setPastOrders(ArrayList<Order> pastOrders) {
        this.pastOrders = pastOrders;
    }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------
    /** 
     * This method changes status of order from current to past.<br>
     * @param _orderCompleted
     */
    public void orderCompleted(Order _orderCompleted){
        this.currentOrder = null;
        this.pastOrders.add(_orderCompleted);
    }

    
    //---------------------------------------
    //	toString
    //---------------------------------------
    /**
     * Given a concrete customer (this), the function overrides the method toString.<br>
     */
    @Override
    public String toString() {
        return "Customer ID: "+this.customerID+"\nName: "+this.name+"\nAddress: "+this.homeAddress;
    }
}
