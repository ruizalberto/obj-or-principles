import java.util.ArrayList;

public class Shop {
    // Fields
    private ArrayList<Order> currentOrders;
    private ArrayList<Order> pastOrders;
    private ArrayList<Customer> customerList;
    private Menu shopMenu;

    // Constructors
    public Shop(){
        this.currentOrders = new ArrayList<Order>();
        this.pastOrders = new ArrayList<Order>();
        this.customerList = new ArrayList<Customer>();
        this.shopMenu = new Menu();
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
    public Menu getShopMenu() {
        return this.shopMenu;
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
    public void setShopMenu(Menu shopMenu) {
        this.shopMenu = shopMenu;
    }

    // EXTRA Methods
    public void addOrder(Order _addOrder){
        this.currentOrders.add(_addOrder);
    }
    
    public void addCustomer(Customer _addCustomer){
        this.customerList.add(_addCustomer);
    }

    public void removeCustomer(Customer _addCustomer){
        this.customerList.remove(_addCustomer);
    }

    public void orderCompleted(Order _orderCompleted){
        this.pastOrders.add(_orderCompleted);
        this.currentOrders.remove(_orderCompleted);
    }

    public void showMenu(){
        this.shopMenu.displayMenu();
    }
}
