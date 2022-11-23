import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		System.out.print("5. Display Shop Menu\n");
		System.out.print("6. Display Food Item Info\n");
		System.out.print("7. Remove Food Item\n");
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

	private static void writeFoodMenu(Shop buymie){
		String foodLocation = "/Users/aruiz/Desktop/Code/obj-or-principles/labs/assignments/A03/A03_Student_Java_Application/foodDatabase/menu.txt";
		String line = null;
		Menu menu = buymie.getShopMenu();
	
		try {
			FileReader fileReader = new FileReader(foodLocation);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
	
			while((line = bufferedReader.readLine()) != null) {
				String[] arrSplit = line.split(",");
				double price = Double.parseDouble(arrSplit[1]);
				Food addFood = new Food(arrSplit[0], price);
				menu.addFood(addFood);
			} 
	
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + foodLocation + "'");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + foodLocation + "'");
		  }

	}

    public static void interactiveMenu() {
        Shop buymie = new Shop();
		writeFoodMenu(buymie);

		boolean finish = false;
		int option;
		Scanner sc = new Scanner(System.in);

        String myStr,
        myStr2;
        int myInt,
        myInt2;

		while (!finish){
			printMenu();
            option = selectOption(sc, 0, 9);
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
					buymie.setShopMenu(menu);

					myStr = enterName(sc);

					Order newOrder = null;
					Customer customerFound = findCustomer(buymie, myStr);
					if (customerFound != null){
						if (customerFound.getCurrentOrder()==null){
							newOrder = new Order(customerFound.getCustomerID(), new ArrayList<Food>());
							myInt = -1;
							while (myInt!=0){
								buymie.showMenu();
								System.out.print("Select an item to be ordered (select 0 to finish): ");
								myInt = selectIntOption(sc);
								while (myInt-1 >= buymie.getShopMenu().getMenu().size()){
									System.out.println("Wrong value!");
									System.out.print("Select an item to be ordered (select 0 to finish): ");
									myInt = selectIntOption(sc);
								}
								if (myInt != 0){
									System.out.print("Select quantity for " + buymie.getShopMenu().getMenu().get(myInt-1).getName()+ ": ");
									myInt2 = selectIntOption(sc);
									if (newOrder != null){
										Food quantityNewFood = buymie.getShopMenu().getMenu().get(myInt-1);
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
							System.out.println("Sorry, you already have an ongoing order.");
						}
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
					System.out.println("---------------\n5. Display Shop Menu\n---------------");
					buymie.showMenu();
				}

				case 6 -> {
					System.out.println("---------------\n6. Add Music Album Item\n---------------");
				}

				case 7 -> {
					System.out.println("---------------\n7. Remove Item\n---------------");
				}

				case 8 -> {
					System.out.println("---------------\n8. Remove Item\n---------------");
				}

				case 9 -> {
					System.out.println("---------------\n9. Display All Customers Spending\n---------------");
					for (Customer customers: buymie.getCustomerList()){
						System.out.println("Customer ID: "+customers.getCustomerID());
						System.out.println("Name: "+customers.getName());
						System.out.println("Address: "+customers.getHomeAddress());
						int totalAmount = 0;
						for (Order orders: customers.getPastOrders()){
							totalAmount += orders.getTotalPrice();
						}
						System.out.println("Total Spent: "+totalAmount);
						System.out.println();
					}
				}
            }
        }
    }

    public static void main(String[] args) {
        // test the functionality of the project
        interactiveMenu();
    }
}
