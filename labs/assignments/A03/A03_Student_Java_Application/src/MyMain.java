import java.util.ArrayList;
import java.util.Scanner;

public class MyMain {
    public static void printMenu(){
		System.out.print("------------------------------------\n");
		System.out.print("			    MENU			  	  \n");
		System.out.print("------------------------------------\n");
		System.out.print("0. Exit\n");
		System.out.print("1. Add Customer\n");
		System.out.print("2. Display Customer Order History\n");
		System.out.print("3. Create New Order\n");
		System.out.print("4. Remove Food Item\n");
		System.out.print("5. Display Food Item Info\n");
		System.out.print("6. Display Shop Food Menu\n");
		System.out.print("7. Add Food Item\n");
		System.out.println("\n\n");
	}

    public static int selectOption(Scanner sc, int min, int max){

		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			System.out.println("Please enter an integer value within the range " + min + " and " + max );
			try {
				res = sc.nextInt();
				sc.nextLine();
				if ((res >= min) && (res <= max)){
                    validOption = true;
                } else {
					System.out.println("Sorry but the option must be within the range " + min + " and " + max);
                }
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    public static int selectIntOption(Scanner sc){
		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			try {
				res = sc.nextInt();
				sc.nextLine();
				validOption = true;
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    public static String selectStringOption(Scanner sc){
		String res = "";
		boolean validOption = false;
		while (!validOption) {
			try {
				res = sc.nextLine();
				if ((res.length() > 0) && (res.charAt(0) >= 'A') && (res.charAt(0) <= 'Z'))
					validOption = true;
				else
					System.out.println("Sorry but the option must be a non-empty string starting by a capital letter");
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a String and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    public static void interactiveMenu() {
        Shop buymie = new Shop();

		boolean finish = false;
		int option;
		Scanner sc = new Scanner(System.in);

        String myStr,
        myStr2;
        int myInt;

		while (!finish){
			printMenu();
            option = selectOption(sc, 0, 7);
			switch (option) {
				case 0 -> finish = true;

				case 1 -> {
					System.out.println("---------------\n1. Add Customer\n---------------");

					System.out.print("Please enter the name for the new customer: ");
					myStr = selectStringOption(sc);
                    System.out.print("Please enter the address for the new customer: ");
					myStr2 = selectStringOption(sc);

                    Customer newCustomer = new Customer(myStr, myStr2);

					buymie.addCustomer(newCustomer);
				}

				case 2 -> {
					System.out.println("---------------\n2. Display Customer Order History\n---------------");

                    System.out.print("Please enter the name for the customer to display order history: ");
					myStr = selectStringOption(sc);

                    boolean found = false;
                    for (Customer customers: buymie.getCustomerList()){
                        if (customers.getName().equals(myStr)){
                            System.out.println("Customer found!");
                            found = true;
                            for (Order pastOrders: customers.getPastOrders()){
                                System.out.print("Order ID:");
                                System.out.println(pastOrders.getOrderID());
                                int counter = 1;
                                for (Food foodList: pastOrders.getBuyList()){
                                    System.out.print("Item "+counter+":");
                                    System.out.println(foodList.getName());
                                    counter++;
                                }
                            }
                            break;
                        }
                    }

                    if (!found){
                        System.out.println("Sorry, no customer is registered with name = "+myStr);
                    }
				}

				case 3 -> {
					System.out.println("---------------\n3. Create New Order\n---------------");

					Menu menu = new Menu();
                    Food meat = new Food("Sirloin Steak", 5);
                    Food fish = new Food("Hake Fillets", 5);
                    menu.addFood(meat);
                    menu.addFood(fish);

                    myInt = -1;
                    while (myInt!=0){
                        menu.displayMenu();
                        System.out.print("Select an item to be ordered (select 0 to finish): ");
                        myInt = selectIntOption(sc);
                        while (menu.getMenu().get(myInt) != null){
                            System.out.print("Select quantity for " + menu.getMenu().get(myInt)+ ": ");
                            myInt = selectIntOption(sc);
                        }
                    }
				}

				case 4 -> {
					// I. We print the message
					System.out.println("---------------\n3. Display All User IDs\n---------------");

					// II. We perform the action
				}

				case 5 -> {
					// I. We print the message
					System.out.println("---------------\n5. Add Book Item\n---------------");

					// II. We ask for the user input to define the item
					System.out.println("Please enter the title for the new book");
					myStr = selectStringOption(sc);
					System.out.println("Please enter the author for the new book");
					myStr2 = selectStringOption(sc);
					System.out.println("Please enter the release year for the new book");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the genre for the new book");
					System.out.println("Please enter the number of pages for the new book");

					// III. We attempt to add the book

					// IV. We inform of the success of the operation
					System.out.println("New book with id " + myInt + " successfully created");
				}

				case 6 -> {
					// I. We print the message
					System.out.println("---------------\n6. Add Music Album Item\n---------------");

					// II. We ask for the user input to define the item
					System.out.println("Please enter the title for the new music album");
					myStr = selectStringOption(sc);
					System.out.println("Please enter the author for the new music album");
					myStr2 = selectStringOption(sc);
					System.out.println("Please enter the release year for the new music album");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the genre for the new music album");
					System.out.println("Please enter if the new music album was album of the year");

					// III. We attempt to add the book
					

					// IV. We inform of the success of the operation
					System.out.println("New music album with id " + myInt + " successfully created");
				}

				case 7 -> {
					// I. We print the message
					System.out.println("---------------\n7. Remove Item\n---------------");

					// II. We ask for the user input to identify the item to be removed
					System.out.println("Please enter the id for the item to be removed");
					myInt = selectIntOption(sc);

					// III. We attempt to remove the user

					// IV. We inform of the success of the operation
				}
            }
        }
    }

    public static void main(String[] args) {
        // test the functionality of the project
        interactiveMenu();

        //Shop buymie = new Shop();
        // Menu menu = new Menu();
        // Food meat = new Food("Sirloin Steak", 5);
        // Food fish = new Food("Hake Fillets", 5);
        // menu.addFood(meat);
        // menu.addFood(fish);
        // Customer alberto = new Customer("Alberto Ruiz", "St Patrick's Street, 9");
        // buymie.addCustomer(alberto);
        // ArrayList<Food> listaCompra = new ArrayList<>();
        // listaCompra.add(meat);
        // meat.setQuantity(4);
        // listaCompra.add(fish);
        // fish.setQuantity(4);
        // Order albertoOrder = new Order(alberto.getCustomerID(), listaCompra);
        // buymie.addOrder(albertoOrder);
        // int total = buymie.getCurrentOrders().get(0).getTotalPrice();
        // System.out.println(total);
    }
}
