public class MyMain {
    public static void main(String[] args) {
        // test the functionality of the project
        Shop buymie = new Shop("Cork County, Model Farm Road");
        Order albertoOrder = new Order();
        Customer alberto = new Customer("Alberto Ruiz", "St Patrick's Street, 9");
        buymie.addCustomer(alberto);
        buymie.addOrder(albertoOrder);
    }
}
