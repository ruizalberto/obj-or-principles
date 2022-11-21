import java.util.ArrayList;
import java.util.Scanner;

public class MyMain {
    public static void printMenu(){
        System.out.println();
		System.out.print("----------------\n");
		System.out.print("     MENU			  	  \n");
		System.out.print("----------------\n");
		System.out.print("0. Exit\n");
		System.out.print("1. Add Customer\n");
		System.out.print("2. Display Customer Order History\n");
		System.out.print("3. Create New Order\n");
		System.out.print("4. Complete Order\n");
		System.out.print("5. Remove Food Item\n");
		System.out.print("6. Display Food Item Info\n");
		System.out.print("7. Display Shop Food Menu\n");
		System.out.print("8. Add Food Item\n");
		System.out.print("9. Display All Customers\n");
		System.out.println("");
	}

    public static int selectOption(Scanner sc, int min, int max){

		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			System.out.print("Please enter an integer value within the range " + min + " and " + max + ": ");
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

	private static Customer findCustomer(Shop buymie, String myStr){
		for (Customer customers: buymie.getCustomerList()){
			if (customers.getName().equals(myStr)){
				System.out.println();
				System.out.println("Customer found!");
				return customers;
			}
		}
		return null;
	}

	private static String enterName(Scanner sc){
		System.out.print("Please enter the name for the customer: ");
		return selectStringOption(sc);
	}

    public static void interactiveMenu() {
        Shop buymie = new Shop();

		boolean finish = false;
		int option;
		Scanner sc = new Scanner(System.in);

        String myStr,
        myStr2;
        int myInt,
        myInt2;

		while (!finish){
			printMenu();
            option = selectOption(sc, 0, 8);
            System.out.println();
			switch (option) {
				case 0 -> finish = true;

				case 1 -> {
					System.out.println("---------------\n1. Add Customer\n---------------");

					myStr = enterName(sc);
                    System.out.print("Please enter the address for the new customer: ");
					myStr2 = selectStringOption(sc);

                    Customer newCustomer = new Customer(myStr, myStr2);

					buymie.addCustomer(newCustomer);
				}

				case 2 -> {
					System.out.println("---------------\n2. Display Customer Order History\n---------------");

					myStr = enterName(sc);

					Customer customerFound = findCustomer(buymie, myStr);
					if (customerFound != null){
						for (Order pastOrders: customerFound.getPastOrders()){
							System.out.println();
							System.out.println("----"+myStr+"'s Order----");
							System.out.println("Order ID: "+pastOrders.getOrderID());
							int counter = 1;
							for (Food foodList: pastOrders.getBuyList()){
								System.out.print("Item "+counter+": ");
								System.out.println(foodList.getName());
								counter++;
							}
							System.out.println();
                        	System.out.println("Total Amount of the Order: "+pastOrders.getTotalPrice()+"€");
						}
					} else {
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

					myStr = enterName(sc);

					Order newOrder = null;
					Customer customerFound = findCustomer(buymie, myStr);
					if (customerFound != null){
						newOrder = new Order(customerFound.getCustomerID(), new ArrayList<Food>());
						myInt = -1;
                        while (myInt!=0){
                            menu.displayMenu();
                            System.out.print("Select an item to be ordered (select 0 to finish): ");
                            myInt = selectIntOption(sc);
                            while (myInt-1 >= menu.getMenu().size()){
                                System.out.println("Wrong value!");
                                System.out.print("Select an item to be ordered (select 0 to finish): ");
                                myInt = selectIntOption(sc);
                            }
                            if (myInt != 0){
                                System.out.print("Select quantity for " + menu.getMenu().get(myInt-1).getName()+ ": ");
                                myInt2 = selectIntOption(sc);
                                if (newOrder != null){
                                    Food quantityNewFood = menu.getMenu().get(myInt-1);
                                    quantityNewFood.setQuantity(myInt2);
                                    newOrder.addFood(quantityNewFood);
                                }
                            }
                        }
						System.out.println();
                        System.out.println("Total Amount of the Order: "+newOrder.getTotalPrice()+"€");
                        buymie.addOrder(newOrder);
						customerFound.setCurrentOrder(newOrder);
					} else {
						System.out.println();
						System.out.println("Sorry, no customer is registered with name = "+myStr);
					}
				}

				case 4 -> {
					System.out.println("---------------\n4. Complete Order\n---------------");

					myStr = enterName(sc);
					Customer customerFound = findCustomer(buymie, myStr);
					if (customerFound != null){
						Order orderCompleted = customerFound.getCurrentOrder();
						System.out.println(myStr+"'s Order Completed. Order ID: "+orderCompleted.getOrderID());
						customerFound.orderCompleted(orderCompleted);
						buymie.orderCompleted(orderCompleted);
					} else {
						System.out.println();
						System.out.println("Sorry, no customer is registered with name = "+myStr);
					}
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

				case 8 -> {
					System.out.println("---------------\n8. Remove Item\n---------------");

					System.out.println("Please enter the id for the item to be removed");
					myInt = selectIntOption(sc);

				}

				case 9 -> {
					System.out.println("---------------\n9. Display All Customers\n---------------");

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
