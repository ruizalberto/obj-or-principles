//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;

//--------------------------------------------------
//
//	CLASS Shop
//
//--------------------------------------------------
/**
 * This class implements the interface ShopInt of the A03 Project of Alberto Ruiz,
 * representing the management of a grocery online shop<br>.
 */
public class Shop extends Menu implements ShopInt{
    
    //---------------------------------------
    //	Fields
    //---------------------------------------
    private ArrayList<Order> currentOrders;
    private ArrayList<Order> pastOrders;
    private ArrayList<Customer> customerList;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Shop<br>
     */
    public Shop(){
        super();
        this.currentOrders = new ArrayList<Order>();
        this.pastOrders = new ArrayList<Order>();
        this.customerList = new ArrayList<Customer>();
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------
    /** 
     * Given a concrete shop (this), the function returns its current orders.<br>
     * @return The current orders of the shop.
     */
    public ArrayList<Order> getCurrentOrders() {
        return this.currentOrders;
    }
    
    /** 
     * Given a concrete shop (this), the function returns its customer list.<br>
     * @return The customer list of the shop.
     */
    public ArrayList<Customer> getCustomerList() {
        return this.customerList;
    }
    
    /** 
     * Given a concrete shop (this), the function returns its past orders.<br>
     * @return The past orders of the shop.
     */
    public ArrayList<Order> getPastOrders() {
        return this.pastOrders;
    }

    //---------------------------------------
    //	SET METHODS
    //---------------------------------------
    /** 
     * Given a concrete shop (this), the function updates its current orders.<br>
     * @param currentOrders
     */
    public void setCurrentOrders(ArrayList<Order> currentOrders) {
        this.currentOrders = currentOrders;
    }
    
    /** 
     * Given a concrete shop (this), the function updates its customer list.<br>
     * @param customerList
     */
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    /** 
     * Given a concrete shop (this), the function updates its past orders.<br>
     * @param pastOrders
     */
    public void setPastOrders(ArrayList<Order> pastOrders) {
        this.pastOrders = pastOrders;
    }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------
    /** 
     * This method adds an order to current orders list.<br>
     * @param _addOrder
     */
    public void addOrder(Order _addOrder){
        this.currentOrders.add(_addOrder);
    }
    
    
    /** 
     * This method adds a customer to customer list.<br>
     * @param _addCustomer
     */
    public void addCustomer(Customer _addCustomer){
        this.customerList.add(_addCustomer);
    }

    
    /** 
     * This method removes a customer from the customer list.<br>
     * @param name
     */
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

    
    /** 
     * This method remvoves order from current order list, and adds it to past order list.<br>
     * @param _orderCompleted
     */
    public void orderCompleted(Order _orderCompleted){
        this.pastOrders.add(_orderCompleted);
        this.currentOrders.remove(_orderCompleted);
    }

    /**
     * Given a concrete shop (this), the function overrides the method displayMenu.<br>
     */
    @Override
    public void displayMenu(){
        System.out.println();
        System.out.println(java.time.LocalDate.now().toString()+"'s Menu");
        int counter = 1;
        for(Food item: this.getMenu()){
            System.out.println("--- "+counter+". "+item.getName()+" ---");
            System.out.print("Price: ");
            System.out.println(item.getPrice());
            System.out.println();
            counter++;
        }
    }
}
