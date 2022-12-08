import java.util.ArrayList;
import java.util.UUID;

public class Customer {
    // Fields
    private String name,
    homeAddress,
    customerID;
    private Order currentOrder;
    private ArrayList<Order> pastOrders;

    // Constructors
    public Customer(){
        this.name = null;
        this.homeAddress = null;
        this.customerID = null;
        this.currentOrder = null;
        this.pastOrders = null;
    }
    public Customer(String _name, String _homeAddress){
        this.name = _name;
        this.homeAddress = _homeAddress;
        this.customerID = UUID.randomUUID().toString();
        this.currentOrder = null;
        this.pastOrders = new ArrayList<Order>();
    }

    
    /** 
     * @return Order
     */
    // GET Methods
    public Order getCurrentOrder() {
        return this.currentOrder;
    }
    
    /** 
     * @return String
     */
    public String getHomeAddress() {
        return this.homeAddress;
    }
    
    /** 
     * @return String
     */
    public String getCustomerID() {
        return this.customerID;
    }
    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    /** 
     * @return ArrayList<Order>
     */
    public ArrayList<Order> getPastOrders() {
        return this.pastOrders;
    }

    
    /** 
     * @param currentOrder
     */
    // SET Methods
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    
    /** 
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * @param pastOrders
     */
    public void setPastOrders(ArrayList<Order> pastOrders) {
        this.pastOrders = pastOrders;
    }

    
    /** 
     * @param _orderCompleted
     */
    // EXTRA Methods
    public void orderCompleted(Order _orderCompleted){
        this.currentOrder = null;
        this.pastOrders.add(_orderCompleted);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Customer ID: "+this.customerID+"\nName: "+this.name+"\nAddress: "+this.homeAddress;
    }
}
