import java.util.ArrayList;
import java.util.UUID;

public class Order {
    // Fields
    private String orderID;
    private String customerID;
    private ArrayList<Food> buyList;

    // Constructors
    public Order(String _customerID, ArrayList<Food> _buyList){
        this.orderID = UUID.randomUUID().toString();
        this.customerID = _customerID;
        this.buyList = _buyList;
    }
}
