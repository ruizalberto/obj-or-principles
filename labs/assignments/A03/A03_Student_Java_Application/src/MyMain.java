import java.util.ArrayList;

public class MyMain {
    public static void printMenu(){
		System.out.print("------------------------------------\n");
		System.out.print("			    MENU			  	  \n");
		System.out.print("------------------------------------\n");
		System.out.print("0. Exit\n");
		System.out.print("1. Add Customer\n");
		System.out.print("2. Remove Customer\n");
		System.out.print("3. Display User Order History\n");
		System.out.print("4. Add Food Item\n");
		System.out.print("5. Remove Food Item\n");
		System.out.print("6. Display Food Item Info\n");
		System.out.print("7. Display Shop Food Menu\n");
		System.out.print("8. Create New Order\n");
		System.out.println("\n\n");
	}

    public static void main(String[] args) {
        // test the functionality of the project
        Shop buymie = new Shop("Cork County, Model Farm Road");
        Menu menu = new Menu();
        Food meat = new Food("Sirloin Steak", 5);
        Food fish = new Food("Hake Fillets", 5);
        menu.addFood(meat);
        menu.addFood(fish);
        Customer alberto = new Customer("Alberto Ruiz", "St Patrick's Street, 9");
        buymie.addCustomer(alberto);
        ArrayList<Food> listaCompra = new ArrayList<>();
        listaCompra.add(meat);
        meat.setQuantity(4);
        listaCompra.add(fish);
        fish.setQuantity(4);
        Order albertoOrder = new Order(alberto.getCustomerID(), listaCompra);
        buymie.addOrder(albertoOrder);
        int total = buymie.getCurrentOrders().get(0).getTotalPrice();
        System.out.println(total);
    }
}
