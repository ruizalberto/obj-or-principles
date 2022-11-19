import java.util.ArrayList;

public class MyMain {
    public static void main(String[] args) {
        // test the functionality of the project
        Shop buymie = new Shop("Cork County, Model Farm Road");
        Customer alberto = new Customer("Alberto Ruiz", "St Patrick's Street, 9");
        Food meat = new Food();
        Food fish = new Food();
        ArrayList<Food> listaCompra = new ArrayList<>();
        listaCompra.add(meat);
        listaCompra.add(fish);
        Order albertoOrder = new Order(alberto.getCustomerID(), listaCompra);
        buymie.addCustomer(alberto);
        buymie.addOrder(albertoOrder);
    }
}
