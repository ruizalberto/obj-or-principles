//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;

//--------------------------------------------------
//
//	INTERFACE Library
//
//--------------------------------------------------
/**
 * This is the main interface for the A03 Project of Alberto Ruiz,
 * representing the management of a grocery online shop<br>.
 */
public interface ShopInt{

    /** 
     * This method adds an order to current orders list.<br>
     * @param _addOrder
     */
    void addOrder(Order _addOrder);

    /** 
     * This method remvoves order from current order list, and adds it to past order list.<br>
     * @param _orderCompleted
     */
    void orderCompleted(Order _orderCompleted);

    /** 
     * This method adds a customer to customer list.<br>
     * @param _addCustomer
     */
    void addCustomer(Customer _addCustomer);

    /** 
     * This method removes a customer from the customer list.<br>
     * @param name
     */
    void removeCustomer(String name);

    /** 
     * This method displays the menu.<br>
     */
    void displayMenu();

    /** 
     * Given a concrete shop (this), the function returns its current orders.<br>
     * @return The current orders of the shop.
     */
    ArrayList<Order> getCurrentOrders();

     /** 
     * Given a concrete shop (this), the function returns its customer list.<br>
     * @return The customer list of the shop.
     */
    ArrayList<Customer> getCustomerList();

    /** 
     * Given a concrete shop (this), the function returns its past orders.<br>
     * @return The past orders of the shop.
     */
    ArrayList<Order> getPastOrders();

    /** 
     * Given a concrete menu (this), the function returns its menu.<br>
     * @return The menu.
     */
    ArrayList<Food> getMenu();

    /** 
     * Given a concrete menu (this), the function updates its menu.<br>
     * @param menu
     */
    void setMenu(ArrayList<Food> menu);
}
