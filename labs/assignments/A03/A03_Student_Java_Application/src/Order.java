import java.util.ArrayList;
import java.util.UUID;

public class Order {
    // Fields
    private String orderID;
    private String customerID;
    private ArrayList<Food> buyList;
    private static final int DELIVERY_FEE = 5;

    // Constructors
    public Order(String _customerID, ArrayList<Food> _buyList){
        this.orderID = UUID.randomUUID().toString();
        this.customerID = _customerID;
        this.buyList = _buyList;
    }

    // GET Methods
    public ArrayList<Food> getBuyList() {
        return this.buyList;
    }
    public String getCustomerID() {
        return this.customerID;
    }
    public String getOrderID() {
        return this.orderID;
    }

    // SET Methods
    public void setBuyList(ArrayList<Food> buyList) {
        this.buyList = buyList;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    // EXTRA Methods
    public void extraItems(Food _extraFood){
        this.buyList.add(_extraFood);
    }

    public int getTotalPrice() {
        int totalAmount = 0;
        for (Food item: this.buyList){
            totalAmount += item.getPrice()*item.getQuantity();
        }
        return totalAmount+DELIVERY_FEE;
    }
}