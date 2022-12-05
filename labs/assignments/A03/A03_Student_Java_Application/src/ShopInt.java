public interface ShopInt {
    void addOrder(Order _addOrder);
    void orderCompleted(Order _orderCompleted);
    void addCustomer(Customer _addCustomer);
    void removeCustomer(String name);
    void displayMenu();
}
