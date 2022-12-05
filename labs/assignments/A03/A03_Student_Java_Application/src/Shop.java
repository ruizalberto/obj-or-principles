import java.util.ArrayList;

public class Shop extends Menu{
    // Fields
    private ArrayList<Order> currentOrders;
    private ArrayList<Order> pastOrders;
    private ArrayList<Customer> customerList;

    // Constructors
    public Shop(){
        super();
        this.currentOrders = new ArrayList<Order>();
        this.pastOrders = new ArrayList<Order>();
        this.customerList = new ArrayList<Customer>();
    }

    // GET Methods
    public ArrayList<Order> getCurrentOrders() {
        return this.currentOrders;
    }
    public ArrayList<Customer> getCustomerList() {
        return this.customerList;
    }
    public ArrayList<Order> getPastOrders() {
        return this.pastOrders;
    }

    // SET Methods
    public void setCurrentOrders(ArrayList<Order> currentOrders) {
        this.currentOrders = currentOrders;
    }
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    public void setPastOrders(ArrayList<Order> pastOrders) {
        this.pastOrders = pastOrders;
    }

    // EXTRA Methods
    public void addOrder(Order _addOrder){
        this.currentOrders.add(_addOrder);
    }
    
    public void addCustomer(Customer _addCustomer){
        this.customerList.add(_addCustomer);
    }

    public void removeCustomer(String name){
        int index = 0;
        for (int i = 0; i<this.customerList.size(); i++){
            if (this.customerList.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        this.customerList.remove(index);
        System.out.println("Successfully removed!");
    }

    public void orderCompleted(Order _orderCompleted){
        this.pastOrders.add(_orderCompleted);
        this.currentOrders.remove(_orderCompleted);
    }
    
}
