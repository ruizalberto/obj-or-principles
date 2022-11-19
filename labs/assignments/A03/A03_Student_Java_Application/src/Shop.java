import java.util.ArrayList;

public class Shop {
    // Fields
    private String address;
    private ArrayList<Order> currentOrders;
    private ArrayList<Order> pastOrders;
    private ArrayList<Customer> customerList;
    private Menu shopMenu;

    // Constructors
    public Shop(String _address){
        this.address = _address;
        this.currentOrders = new ArrayList<Order>();
        this.pastOrders = new ArrayList<Order>();
        this.customerList = new ArrayList<Customer>();
        this.shopMenu = new Menu();
    }

    // GET Methods
    public String getAddress() {
        return this.address;
    }
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
    public void setAddress(String address) {
        this.address = address;
    }
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
    public void orderCompleted(Order _orderCompleted){
        this.pastOrders.add(_orderCompleted);
        this.currentOrders.remove(_orderCompleted);
    }
    public void showMenu(){
        this.shopMenu.displayMenu();
    }
}
