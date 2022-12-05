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

    // GET Methods
    public Order getCurrentOrder() {
        return this.currentOrder;
    }
    public String getHomeAddress() {
        return this.homeAddress;
    }
    public String getCustomerID() {
        return this.customerID;
    }
    public String getName() {
        return this.name;
    }
    public ArrayList<Order> getPastOrders() {
        return this.pastOrders;
    }

    // SET Methods
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPastOrders(ArrayList<Order> pastOrders) {
        this.pastOrders = pastOrders;
    }

    // EXTRA Methods
    public void orderCompleted(Order _orderCompleted){
        this.currentOrder = null;
        this.pastOrders.add(_orderCompleted);
    }

    @Override
    public String toString() {
        return "Customer ID: "+this.customerID+"\nName: "+this.name+"\nAddress: "+this.homeAddress;
    }
}
