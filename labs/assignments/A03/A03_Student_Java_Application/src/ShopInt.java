import java.util.ArrayList;

public interface ShopInt{
    void addOrder(Order _addOrder);
    void orderCompleted(Order _orderCompleted);
    void addCustomer(Customer _addCustomer);
    void removeCustomer(String name);
    void displayMenu();
    ArrayList<Order> getCurrentOrders();
    ArrayList<Customer> getCustomerList();
    ArrayList<Order> getPastOrders();
    ArrayList<Food> getMenu();
    void setMenu(ArrayList<Food> menu);
}
