import java.util.ArrayList;

public class MyMain {
    public static void main(String[] args) {
        // test the functionality of the project
        Shop buymie = new Shop("Cork County, Model Farm Road");
        Customer alberto = new Customer("Alberto Ruiz", "St Patrick's Street, 9");
        buymie.addCustomer(alberto);
        Food meat = new Food(5);
        Food fish = new Food(5);
        ArrayList<Food> listaCompra = new ArrayList<>();
        listaCompra.add(meat);
        listaCompra.add(fish);
        Order albertoOrder = new Order(alberto.getCustomerID(), listaCompra);
        buymie.addOrder(albertoOrder);
        int total = buymie.getCurrentOrders().get(0).getTotalPrice();
        System.out.println(total);
    }
}
